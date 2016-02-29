/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.bean;

import com.iselect.kernal.pageflow.annotation.ResultTitleType;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Hiep
 */
public interface RequestPath{
    public String getClazz();
    public void setClazz(String clazz);
    
    public String getPath();
    public void setPath(String path);
    
    public RequestMethod getMethod();
    public void setMethod(RequestMethod method);
    
    public List<RequestPath> getSubpaths();
    public void setSubpaths(List<RequestPath> paths);
    public void addSubpath(RequestPath path);
    
    public ResultTitleType[] getResultTitles();
    public void setResultTitles(ResultTitleType[] titles);
    
    public void setDefaultView(String view);
    public String getDefaultView();
}
