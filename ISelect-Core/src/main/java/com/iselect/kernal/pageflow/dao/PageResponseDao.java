/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.dao;

import com.iselect.kernal.exception.ISelectDaoException;
import java.io.Serializable;
import java.util.List;
import com.iselect.kernal.pageflow.model.PageResponseModel;

/**
 * @author Hiep
 * @param <T>
 * @param <ID>
 */
public interface PageResponseDao<T extends PageResponseModel> {

    public String REQUEST_ID_VAR = "requestId";
    public String RESULT_TITLE_VAR = "resultTitle";
    public String GET_BY_REQUEST = "from %s where requestId=:" + REQUEST_ID_VAR;
    public String GET_BY_REQUEST_TITLE = "from %s where requestId=:" + REQUEST_ID_VAR + " and resultTitle=:" + RESULT_TITLE_VAR;

    public List<T> savePageResponse(List<? extends T> pageFlowModels);
    
    /**
     * The method inserts a PageFlowResponseModel into database.
     * before the model is inserted into database the method will check whether the model existing
     * in the database. A Response is determined by its <b>requestId</b> and <b>resultTile</b>
     * There are three cases could be happened
     * (1) the model is existing in the database, the retrieved model will be returned, and no any exception is thrown.
     * (2) the model doesn't existing in the database, it is inserted into database and method returns null.
     * (2) exception could be thrown while (1) and (2) performing.
     * @param model
     * @return
     * @throws ISelectDaoException 
     */
    public T savePagResponse(T model)throws ISelectDaoException;

    /**
     * get all PageFlowResponses are valid and active
     * @return
     * @throws ISelectDaoException 
     */
    public List<T> getPageResponses() throws ISelectDaoException;

    /**
     * get all responses belong to a request having id as parameter
     *
     * @param requestId
     * @return
     * @throws ISelectDaoException
     */
    public List<T> getPageResponses(Long requestId) throws ISelectDaoException;

    /**
     * getting response with determined id
     *
     * @param id
     * @return
     * @throws ISelectDaoException
     */
    public T getPageResponse(Long id) throws ISelectDaoException;

    /**
     * the method return a response which has requestId and resultTitle equal to
     * transfered parameters
     *
     * @param requestId
     * @param resultTitle
     * @return
     * @throws ISelectDaoException
     */
    public T getPageResponse(Long requestId, String resultTitle) throws ISelectDaoException;

    public void updatePageResponse(T response) throws ISelectDaoException;

}
