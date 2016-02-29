/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.bean;

import com.iselect.kernal.pageflow.annotation.ResultTitleType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Hiep
 */
public class RequestPathImpl implements RequestPath{
    
    private String path;
    private String clazz;
    private RequestMethod method;
    private List<RequestPath> subpaths;
    private ResultTitleType[] resultTitles;
    private String defaultView;

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String getClazz() {
        return clazz;
    }

    @Override
    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Override
    public RequestMethod getMethod() {
        return method;
    }

    @Override
    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    @Override
    public List<RequestPath> getSubpaths() {
        return subpaths;
    }

    @Override
    public void setSubpaths(List<RequestPath> subpaths) {
        this.subpaths = subpaths;
    }

    @Override
    public void addSubpath(RequestPath path) {
        this.subpaths.add(path);
    }

    @Override
    public ResultTitleType[] getResultTitles() {
        return resultTitles;
    }

    @Override
    public void setResultTitles(ResultTitleType[] resultTitles) {
        this.resultTitles = resultTitles;
    }

    @Override
    public String getDefaultView() {
        return defaultView;
    }

    @Override
    public void setDefaultView(String defaultView) {
        this.defaultView = defaultView;
    }
    
}
