/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.entity;

import com.iselect.kernal.BaseEntityImpl;
import com.iselect.kernal.util.LambdaUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 *
 * @author Hiep
 * @param <T>
 */
@MappedSuperclass
public abstract class PageRequestEntityImpl<T extends PageResponseEntityImpl> extends BaseEntityImpl implements PageRequestEntity<T> {

    @Column(name = "RQT_CLASS")
    protected String actionClazz;
    
    @Column(name = "RQT_PATH")
    protected String actionPath;
    
    @Column(name = "RQT_METHOD")
    protected String actionMethod;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "request")
    protected List<T> pageResponses = new ArrayList<>();

    public PageRequestEntityImpl() {
        super();
    }

    @Override
    public String getActionClazz() {
        return actionClazz;
    }

    @Override
    public void setActionClazz(String actionClazz) {
        this.actionClazz = actionClazz;
    }

    @Override
    public String getActionPath() {
        return actionPath;
    }

    @Override
    public void setActionPath(String actionPath) {
        this.actionPath = actionPath;
    }

    @Override
    public String getActionMethod() {
        return actionMethod;
    }

    @Override
    public void setActionMethod(String actionMethod) {
        this.actionMethod = actionMethod;
    }

    @Override
    public void addPageResponse(T t) {
        this.pageResponses.add(t);
    }

    @Override
    public T removePageResponse(T t) {
        pageResponses.remove(t);
        return t;
    }

    @Override
    public T getPageResponse(String resultTitle) {
//        String responseKey = PageFlowUtil.buildPageFlowResponseKey(
//                Long.toString(this.getId()), resultTitle);
//        return this.pageFlowResponses.get(responseKey);
        return null;
    }

    @Override
    public List<T> getPageResponses() {
        return pageResponses;
    }

    @Override
    public void setPageFlowResponses(List<T> pageFlowResponses) {
        this.pageResponses = pageFlowResponses;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PageRequestEntityImpl)) {
            return false;
        }

        PageRequestEntityImpl pageFlow = (PageRequestEntityImpl) obj;
        return LambdaUtil.compareString.apply(this.getActionPath(), pageFlow.getActionPath())
                && LambdaUtil.compareString.apply(this.getActionMethod(), pageFlow.getActionMethod());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.actionPath);
        hash = 17 * hash + Objects.hashCode(this.actionMethod);
        return hash;
    }

}
