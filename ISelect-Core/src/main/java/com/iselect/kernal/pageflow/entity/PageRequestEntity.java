/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.entity;

import com.iselect.kernal.BaseEntity;
import com.iselect.kernal.table.entity.TableItem;
import java.util.List;

/**
 *
 * @author Hiep
 * @param <T>
 * @param <R>
 */
public interface PageRequestEntity<T extends PageResponseEntity> extends BaseEntity {
    
    public static final String PARAM_ACTION_PATH = "actionPath";
    public static final String PARAM_ACTION_METHOD = "actionMethod";
    
    public String getActionClazz();
    public void setActionClazz(String actionClazz);

    public String getActionPath();
    public void setActionPath(String actionPath);

    public String getActionMethod();
    public void setActionMethod(String actionMethod);

    public T getPageResponse(String key);
    public void addPageResponse(T t);
    public T removePageResponse(T t);
    
    public List<T> getPageResponses();
    public void setPageFlowResponses(List<T> pageFlowResponses);
}
