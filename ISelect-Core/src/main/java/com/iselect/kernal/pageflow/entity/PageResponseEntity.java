/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.entity;

import com.iselect.kernal.BaseEntity;

/**
 *
 * @author Hiep
 * @param <T>
 */
public interface PageResponseEntity<T extends PageRequestEntity> extends BaseEntity{
    
    String PARAM_REQUEST="request";
    
    public T getRequest();
    public void setRequest(T request);
    
    /**
     * @HiepNguyen
     * ResultTitleType could be SUCCESS, ERORR, or OTHER
     * @return 
     */
    public String getResultTitle();
    public void setResultTitle(String resultTitle);

    /**
     * ReturnType could be forward, or redirect
     * @return true if redirect otherwise it is false
    */
    public boolean getReturnRedirect();
    public void setReturnRedirect(boolean returnType);

    /**
     * @HiepNguyen
     * Ether returnPath or returnView has value.
     * I separate them because I would like to draw map of page flow
     * @return 
     */
    public T getReturnPath();
    public void setReturnPath(T target);

    public String getReturnView();
    public void setReturnView(String returnView);
}
