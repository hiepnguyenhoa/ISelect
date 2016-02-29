/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.model;

import com.iselect.kernal.BaseModel;
import com.iselect.kernal.pageflow.entity.PageRequestEntity;

/**
 *
 * @author Hiep
 * @param <T>
 */
public interface PageRequestModel<T extends PageResponseModel> extends BaseModel, PageRequestEntity<T>{
    public static final String QUERY_BY_PATH_METHOD = "PageFlowRequest.getPageRequestByPathAndMethod";
    public static final String QUERY_BY_STATUSFLAG = "PageFlowRequest.getPageRequestsByStatusFlag";
    
}
