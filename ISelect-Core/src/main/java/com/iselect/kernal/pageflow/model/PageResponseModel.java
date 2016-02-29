/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.model;

import com.iselect.kernal.BaseModel;
import com.iselect.kernal.pageflow.entity.PageResponseEntity;

/**
 *
 * @author Hiep
 * @param <T>
 */
public interface PageResponseModel<T extends PageRequestModel> extends BaseModel, PageResponseEntity<T>{
    String QUERY_RESPONSES_BY_STATUS="PageResponse.getResponsesByStatus";
    String QUERY_RESPONSES_BY_REQUEST_ID="PageResponse.getResponsesByRequestId";
}
