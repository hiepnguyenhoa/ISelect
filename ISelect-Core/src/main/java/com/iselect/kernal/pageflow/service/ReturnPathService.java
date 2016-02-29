/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.service;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Hiep
 */
public interface ReturnPathService {
    String ERROR_PAGE="redirect:/error";
    String getReturnPath(String actionPath, String resultTitle);// throws PageFlowRequestNotFoundException, PageFlowResponseNotFoundException;
    String getReturnPath(String actionPath, RequestMethod actionMethod, String resultTitle);// throws PageFlowRequestNotFoundException, PageFlowResponseNotFoundException;
}
