/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.service;

import com.iselect.kernal.exception.ISelectDaoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
import com.iselect.kernal.pageflow.model.PageRequestModel;
import com.iselect.kernal.pageflow.model.PageResponseModel;
import com.iselect.kernal.pageflow.dao.PageRequestDaoExt;
import com.iselect.kernal.pageflow.dao.PageResponseDao;

/**
 *
 * @author Hiep
 */
@Service
public class ReturnPathServiceImpl implements ReturnPathService {

    @Autowired
    private PageRequestDaoExt requestDao;

    @Autowired
    private PageResponseDao responseDao;

    @Override
    public String getReturnPath(String actionPath, String resultTitle)// throws PageFlowRequestNotFoundException, PageFlowResponseNotFoundException
    {
        return this.getReturnPath(actionPath, RequestMethod.GET, resultTitle);
    }

    @Override
    public String getReturnPath(String actionPath, RequestMethod actionMethod, String resultTitle)// throws PageFlowRequestNotFoundException, PageFlowResponseNotFoundException
    {
        PageRequestModel requestModel = null;
        try {
            requestModel = this.requestDao.getPageRequest(actionPath, actionMethod);
        } catch (ISelectDaoException ex) {
            Logger.getLogger(ReturnPathServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//            throw new PageFlowRequestNotFoundException(ex);
            return ERROR_PAGE;
        }
        
        if(requestModel==null)
            return ERROR_PAGE;

        PageResponseModel response;
        try {
            response = this.responseDao.getPageResponse(requestModel.getId(), resultTitle);
            if (response == null) {
                return ERROR_PAGE;
            }
        } catch (ISelectDaoException ex) {
            Logger.getLogger(ReturnPathServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return ERROR_PAGE;
        }
        String returnPath = "";
        if (response.getReturnPath() != null) {
            returnPath = response.getReturnRedirect() ? "redirect:" : "";
        }
        return returnPath + response.getReturnView();
    }

}
