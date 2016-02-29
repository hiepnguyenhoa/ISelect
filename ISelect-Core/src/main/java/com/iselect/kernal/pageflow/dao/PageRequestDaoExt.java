/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.dao;

import com.iselect.kernal.ISelectDao;
import com.iselect.kernal.exception.ISelectDaoException;
import com.iselect.kernal.pageflow.entity.PageFlowRequestType;
import java.io.Serializable;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import com.iselect.kernal.pageflow.model.PageRequestModel;

/**
 *
 * @author Hiep
 * @param <T>
 * @param <ID>
 */
public interface PageRequestDaoExt<T extends PageRequestModel> extends ISelectDao<T>{
    String REQUEST_ID="id";
    String SECURITY_ORDER="securityOrder";
    
    String GET_REQUEST="FROM %s WHERE 1=1";
    String GET_REQUEST_BY_PATH_METHOD="FROM %s where actionPath=:actionPath and actionMethod=:actionMethod";
    String REQUEST_UPDATE_WITH_SECURITY_ORDER="update %s set securityOrder=:securityOrder where id=:id";
    String REQUEST_GET_ORDER_BY_SECURITY_ORDER="from %s r where r.validFlag=true and r.statusFlag=1 Order By securityOrder";
    
    /**
     * The method inserts a PageFlowRequestModel object into database.
     * Before inserting the object the method checks whether the object's values are existing in the database.
     * The values are used to determined existing in the database consiting of actionPath and actionMethod.
     * There are three cases returned by the method:
     * (1) if the object's values are in database, returns the object retrieved from database
     * (2) if the values aren't in database, the new object will be inserted and return null
     * (3) exceptions can be thrown during the process.
     * @param requestModel
     * @return
     * @throws ISelectDaoException 
     */
    public T savePageRequest(T requestModel)throws ISelectDaoException;
    public List<T> savePageFlowRequest(List<? extends T> pageFlowModels);
    
    public T getPageFlowRequest(Long id) throws ISelectDaoException;
    public T getPageRequest(String actionPath, RequestMethod actionMethod) throws ISelectDaoException;
    public T getPageRequest(String actionPath, String actionMethod) throws ISelectDaoException;
    
    public List<? extends T> getPageRequests() throws ISelectDaoException;
    public List<? extends T> getPageRequests(PageFlowRequestType type) throws ISelectDaoException;
    public List<? extends T> getPageFlowRequestsOrderBySecurityOrder() throws ISelectDaoException;
    
    
    public void updateSecurityOrder(T request)throws ISelectDaoException;

    

}
