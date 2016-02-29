/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.listener;

import java.util.List;
import com.iselect.kernal.pageflow.model.PageRequestModel;
import com.iselect.kernal.pageflow.model.PageResponseModel;

/**
 *
 * @author Hiep
 */
public class PageFlowRequestGetListenerImpl<T extends PageRequestModel> implements PageFlowRequestGetListener<T> {

    @Override
    public void postProcessModel(PageRequestModel model) {
        List<PageResponseModel> responses=model.getPageResponses();
        for(PageResponseModel _response: responses){
            _response.getResultTitle();
        }
    }

    @Override
    public void postProcessModels(List<T> models) {
        for (T model : models) {
            postProcessModel(model);
        }
    }

}
