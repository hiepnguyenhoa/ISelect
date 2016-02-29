/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.util;

import com.iselect.kernal.pageflow.bean.RequestPath;
import com.iselect.kernal.pageflow.annotation.ResultTitleType;
import com.iselect.kernal.pageflow.model.PageRequestModelImpl;
import com.iselect.kernal.pageflow.model.PageResponseModelImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import com.iselect.kernal.pageflow.model.PageRequestModel;
import com.iselect.kernal.pageflow.model.PageResponseModel;

/**
 *
 * @author Hiep
 */
public class PageFlowUtil {

    public static final String INDEX_PATH = "/index";
    public static final RequestMethod METHOD_GET = RequestMethod.GET;

    public static List<PageRequestModel> toPageFlowModel(RequestPath requestPath, String rootPath) {
        List<PageRequestModel> models = new ArrayList<>();
        String path = rootPath==null?requestPath.getPath():rootPath + requestPath.getPath();
        if (requestPath.getSubpaths() == null || requestPath.getSubpaths().isEmpty()) {
            PageRequestModelImpl _request = new PageRequestModelImpl();
            _request.setActionClazz(requestPath.getClazz());
            _request.setActionPath(path);
            _request.setActionMethod(requestPath.getMethod().name());
            
            for (ResultTitleType _titleType : requestPath.getResultTitles()) {
                PageResponseModelImpl __response = new PageResponseModelImpl();
                __response.setResultTitle(_titleType.name());
                __response.setRequest(_request);
                __response.setReturnView(requestPath.getDefaultView());
                _request.addPageResponse(__response);
            }
            models.add(_request);
        }else{
            for(RequestPath _requestPath:requestPath.getSubpaths()){
                List<PageRequestModel> _children=toPageFlowModel(_requestPath, path);
                models.addAll(_children);
            }
        }

        return models;
    }
}
