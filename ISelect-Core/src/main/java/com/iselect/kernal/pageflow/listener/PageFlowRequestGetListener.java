/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.listener;

import com.iselect.kernal.dao.listener.ModelGetListener;
import com.iselect.kernal.pageflow.model.PageRequestModel;

/**
 *
 * @author Hiep
 * @param <T>
 */
public interface PageFlowRequestGetListener<T extends PageRequestModel> extends ModelGetListener<T>{
    
}
