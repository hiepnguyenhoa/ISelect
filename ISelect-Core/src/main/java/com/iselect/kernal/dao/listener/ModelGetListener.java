/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.dao.listener;

import com.iselect.kernal.BaseModel;
import java.util.List;

/**
 *
 * @author Hiep
 * @param <T>
 */
public interface ModelGetListener<T extends BaseModel>{
    public void postProcessModels(List<T> models);
    public void postProcessModel(T model);    
}
