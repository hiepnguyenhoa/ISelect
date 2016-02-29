/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.entity;

import com.iselect.kernal.BaseEntityImpl;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Hiep
 * @param <T>
 */
@Entity
@Table(name="PAGE_RESPONSE")
public class PageResponseEntityImpl<T extends PageRequestEntity> extends BaseEntityImpl implements PageResponseEntity<T>{
    @ManyToOne
    @JoinColumn(name="RQT_ID")
    protected T request;
    protected String resultTitle;
    protected boolean returnRedirect=false;
    protected T returnPath;
    protected String returnView;

    @Override
    public T getRequest() {
        return request;
    }
    
    @Override
    public void setRequest(T request) {
        this.request = request;
    }

    @Override
    public String getResultTitle() {
        return resultTitle;
    }

    @Override
    public void setResultTitle(String resultTitle) {
        this.resultTitle = resultTitle;
    }

    @Override
    public boolean getReturnRedirect() {
        return returnRedirect;
    }

    @Override
    public void setReturnRedirect(boolean returnType) {
        this.returnRedirect = returnType;
    }

    @Override
    public T getReturnPath() {
        return returnPath;
    }

    @Override
    public void setReturnPath(T returnPath) {
        this.returnPath = returnPath;
    }

    @Override
    public String getReturnView() {
        return returnView;
    }

    @Override
    public void setReturnView(String returnView) {
        this.returnView = returnView;
    }

    

}
