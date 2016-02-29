/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.service;

import com.iselect.kernal.exception.ISelectDaoException;
import com.iselect.kernal.pageflow.bean.RequestPath;
import com.iselect.kernal.pageflow.bean.RequestPathImpl;
import com.iselect.kernal.pageflow.annotation.ResultTitle;
import com.iselect.kernal.pageflow.exception.ResultTitleException;
import com.iselect.kernal.pageflow.model.PageResponseModelImpl;
import com.iselect.kernal.pageflow.util.PageFlowUtil;
import com.iselect.kernal.ISelectServiceAbst;
import com.iselect.kernal.exception.ISelectException;
import com.iselect.kernal.pageflow.entity.PageFlowRequestType;
import com.iselect.kernal.pageflow.model.PageRequestModelImpl;
import com.iselect.kernal.util.BeanUtil;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.iselect.kernal.pageflow.model.PageRequestModel;
import com.iselect.kernal.pageflow.model.PageResponseModel;
import com.iselect.kernal.pageflow.dto.PageResponseDto;
import com.iselect.kernal.pageflow.dao.PageRequestDaoExt;
import com.iselect.kernal.pageflow.dao.PageResponseDao;
import com.iselect.kernal.pageflow.dto.PageRequestDto;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author Hiep
 */
@Service
@Transactional
public class PageFlowServiceImpl extends ISelectServiceAbst implements PageFlowService {

    @Autowired
    private PageRequestDaoExt requestDao;

    @Autowired
    private PageResponseDao responseDao;

    @Override
    public void parseControllers(String packageName) {
        if (packageName.startsWith(PREFIX_CLASS)) {
            String className = packageName.substring(PREFIX_CLASS.length());
            parserClazz(className);
        } else {
            parserPackage(packageName);
        }
    }

    private void parserPackage(String packageName) {
        Reflections reflections = new Reflections(packageName);
        for (Class clazz : reflections.getTypesAnnotatedWith(RequestMapping.class)) {
            processClass(clazz);
        }
    }

    private void parserClazz(String className) {
        try {
            Class clazz = Class.forName(className);
            processClass(clazz);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PageFlowServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void processClass(Class clazz) {
        List<RequestPath> requestPaths = null;
        try {
            RequestPath classPath = getClassRequestMapping(clazz);
            List<RequestPath> methodPaths = getMethodRequestMapping(clazz);

            if (classPath != null) {
                classPath.setSubpaths(methodPaths);
                requestPaths = new ArrayList<>();
                requestPaths.add(classPath);
            } else {
                requestPaths = methodPaths;
            }

            //convert to List<PageFlowModel> then save them
            List<PageRequestModel> _pageflowModels = new ArrayList<>();
            for (RequestPath _requestPath : requestPaths) {
                _pageflowModels.addAll(PageFlowUtil.toPageFlowModel(_requestPath, null));
            }
//            requestDao.savePageFlowRequest(_pageflowModels);
            this.insertPageFlowRequest(_pageflowModels);

        } catch (ResultTitleException ex) {
            Logger.getLogger(PageFlowServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private RequestPath getClassRequestMapping(Class<?> clazz) throws ResultTitleException {
        RequestMapping mapping = clazz.getAnnotation(RequestMapping.class);
        ResultTitle title = clazz.getAnnotation(ResultTitle.class);
        if (title != null) {
            throw new ResultTitleException("ResultTitle was declared at class level");
        }
        List<RequestPath> paths = buildRequestPath(clazz, mapping, title, false);
        return paths.get(0);
    }

    private List<RequestPath> getMethodRequestMapping(Class clazz) {
        List<RequestPath> requestPaths = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            //process RequestMapping
            RequestMapping mapping = method.getAnnotation(RequestMapping.class);
            //the method doesn't have RequestMapping annotation
            if (mapping == null) {
                continue;
            }
            //process ResultTitle
            ResultTitle title = method.getAnnotation(ResultTitle.class);

            List<RequestPath> _methodPaths = buildRequestPath(clazz, mapping, title, true);
            requestPaths.addAll(_methodPaths);
        }

        return requestPaths;
    }

    private List<RequestPath> buildRequestPath(Class clazz, RequestMapping mapping, ResultTitle title, boolean methodLevel) {
        List<RequestPath> paths = new ArrayList<>();
        for (String _path : mapping.value()) {
            RequestMethod[] _methods = mapping.method();
            RequestMethod _method = _methods.length > 0 ? _methods[0] : RequestMethod.GET;
            RequestPath _requestPath = buildRequestPath(clazz, _path, _method, title);
            paths.add(_requestPath);
        }

        //process for index as default at method level
        if (methodLevel && paths.isEmpty()) {
            RequestPath _requestPath = buildRequestPath(clazz, PageFlowUtil.INDEX_PATH, PageFlowUtil.METHOD_GET, title);
            paths.add(_requestPath);
        }

        return paths.isEmpty() ? null : paths;
    }

    private RequestPath buildRequestPath(Class clazz, String path, RequestMethod method, ResultTitle title) {
        RequestPath requestPath = new RequestPathImpl();
        requestPath.setClazz(clazz.getName());
        requestPath.setPath(path);
        requestPath.setMethod(method);
        if (title != null) {
            requestPath.setResultTitles(title.values());
            requestPath.setDefaultView(title.view());
        }
        return requestPath;
    }

    @Override
    @Transactional(readOnly = true)
    public List<? extends PageRequestDto> getPageFlowRequests() throws ISelectException {
        return getPageFlowRequests(PageFlowRequestType.ALL);
    }

    @Override
    @Transactional(readOnly = true)
    public List<? extends PageRequestDto> getPageFlowRequests(PageFlowRequestType type) throws ISelectException {
        try {
            List<PageRequestModel> models = requestDao.getPageRequests(type);
            return convertToDto(models);
        } catch (InstantiationException | IllegalAccessException | ISelectDaoException ex) {
            Logger.getLogger(PageFlowServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ISelectException(ex);
        }
    }

    @Override
    public List<? extends PageRequestDto> getPageFlowRequestsOrderBySecurityOrder() throws ISelectException {
        try {
            List<PageRequestModel> models = requestDao.getPageFlowRequestsOrderBySecurityOrder();
            return convertToDto(models);
        } catch (InstantiationException | IllegalAccessException | ISelectDaoException ex) {
            Logger.getLogger(PageFlowServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ISelectException(ex);
        }
    }

    private List<? extends PageRequestDto> convertToDto(List<PageRequestModel> models) throws InstantiationException, IllegalAccessException {
        List<PageRequestDto> dtos = new ArrayList<>(models.size());
        for (PageRequestModel requestModel : models) {
            dtos.add(convertRequestModelToDto(requestModel));
        }
        return dtos;
    }

    private PageRequestDto convertRequestModelToDto(PageRequestModel requestModel) {
        if (requestModel == null) {
            return null;
        }
        PageRequestDto requestDto = dtoFactory.createPageRequest();
        BeanUtils.copyProperties(requestModel, requestDto);
        List<PageResponseModel> responseModels = requestModel.getPageResponses();
        for (PageResponseModel responseModel : responseModels) {
            PageResponseDto responseDto = dtoFactory.createPageResponse();
            BeanUtils.copyProperties(responseModel, responseDto);
        }
        return requestDto;
    }

    @Override
    public PageRequestDto getPageRequest(long id) {
        throw new UnsupportedOperationException();
    }

    private PageRequestModel getPageFlowRequestById(long id) throws ISelectDaoException {
        return this.requestDao.getPageFlowRequest(id);
    }

    @Override
    public List<? extends PageResponseDto> getPageFlowResponses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<? extends PageResponseDto> getPageFlowResponses(long requestId) {
        List<? extends PageResponseDto> responses = null;
        try {
            responses = this.responseDao.getPageResponses(requestId);

        } catch (ISelectDaoException ex) {
            Logger.getLogger(PageFlowServiceImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return responses;
    }

    @Override
    public PageRequestDto getPageFlowResponse(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private PageResponseModel getPageFlowResponseById(Long id) throws ISelectDaoException {
        return this.responseDao.getPageResponse(id);
    }

    /**
     * @param requestModels
     * @return list of error objects
     */
    private List<PageRequestModel> insertPageFlowRequest(List<? extends PageRequestModel> requestModels) {
        List<PageRequestModel> models = new ArrayList<>();
        for (PageRequestModel _requestModel : requestModels) {
            try {
                PageRequestModel _model = this.insertPageFlowRequest(_requestModel);
                /*the request model is existing in database, we need to process saving each its reponse object*/
                if (_model != null) {
                    _requestModel.setId(_model.getId());
                    this.insertPageFlowResponse(_requestModel);

                }
            } catch (ISelectException ex) {
                Logger.getLogger(PageFlowServiceImpl.class
                        .getName()).log(Level.SEVERE, null, ex);
                models.add(_requestModel);
            }
        }
        return models;
    }

    @Override
    public void insertPageFlowRequest(PageRequestDto requestDto) throws ISelectException {
        PageRequestModel requestModel = modelFactory.createPageRequest();
        BeanUtils.copyProperties(requestDto, requestModel);
        List<PageResponseDto> responseDtos = requestDto.getPageResponses();
        for(PageResponseDto responseDto:responseDtos){
            PageResponseModel responseModel = modelFactory.createPageResponse();
            BeanUtils.copyProperties(responseDto, responseModel);
            requestModel.addPageResponse(responseModel);
        }
        insertPageFlowRequest(requestModel);
    }

    private PageRequestModel insertPageFlowRequest(PageRequestModel requestModel) throws ISelectException {
        try {
            return requestDao.savePageRequest(requestModel);
        } catch (ISelectDaoException ex) {
            Logger.getLogger(PageFlowServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ISelectException(ex);
        }
    }

    @Override
    public void insertPageFlowResponse(PageResponseDto responseDto) throws ISelectException {
        throw new UnsupportedOperationException();
    }

    private void insertPageFlowResponse(PageRequestModel requestModel) {
        if (requestModel == null) {
            return;
        }
        /*??? If I don't cast the request.getPageFlowResponses() return list of PageFlowResponseEntityAbst*/
        PageRequestModelImpl request = (PageRequestModelImpl) requestModel;
        for (PageResponseModel _responseModel : request.getPageResponses()) {
            try {
                _responseModel.setRequest(requestModel);
                insertPageFlowResponse(_responseModel);

            } catch (ISelectException ex) {
                Logger.getLogger(PageFlowServiceImpl.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private PageResponseModel insertPageFlowResponse(PageResponseModel responseModel) throws ISelectException {
        try {
            return responseDao.savePagResponse(responseModel);
        } catch (ISelectDaoException ex) {
//            Logger.getLogger(PageFlowServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ISelectException(ex);
        }
    }

    @Override
    public void updatePageResponses(PageRequestDto pageflowRequest) {
        List<PageResponseDto> responseDtos = pageflowRequest.getPageResponses();
        for (PageResponseDto _responseDto : responseDtos) {
            try {
                long _id = _responseDto.getId();
                PageResponseModel _responseModel = this.getPageFlowResponseById(_id);
                if (_responseDto.getReturnPathId() > 0) {
                    PageRequestModel _requestModel = this.getPageFlowRequestById(_responseDto.getReturnPathId());
                    _responseDto.setReturnPath(_requestModel);
                }
                toPageFlowResponseModel(_responseDto, _responseModel);
                this.responseDao.updatePageResponse(_responseModel);

            } catch (ISelectDaoException ex) {
                Logger.getLogger(PageFlowServiceImpl.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * the main purpose of the method is to update data to model to update into
     * DBSM the method will clone those properties from responseDto to
     * responseModel: - returnRedirect - returnPath - returnView - modifiedDate
     * - transId - userJob
     *
     * @param responseDto
     * @param responseModel
     * @return
     */
    private PageResponseModel toPageFlowResponseModel(PageResponseDto responseDto, PageResponseModel responseModel) {
        if (responseDto == null) {
            return null;
        }
        if (responseModel == null) {
            responseModel = new PageResponseModelImpl();
        }
        responseModel.setId(responseDto.getId());
        responseModel.setReturnRedirect(responseDto.getReturnRedirect());
        responseModel.setReturnPath(responseDto.getReturnPath());
        responseModel.setReturnView(responseDto.getReturnView());
        responseModel.setTransId(responseDto.getTransId());
        responseModel.setUserJob(responseDto.getUserJob());
        responseModel.setModifiedDate(java.sql.Date.valueOf(LocalDate.now()));
        return responseModel;
    }
}
