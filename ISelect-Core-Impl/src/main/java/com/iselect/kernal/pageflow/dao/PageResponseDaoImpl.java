/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.dao;

import com.iselect.kernal.ISelectDaoAbst;
import com.iselect.kernal.exception.ISelectDaoException;
import com.iselect.kernal.pageflow.model.PageRequestModelImpl;
import com.iselect.kernal.pageflow.model.PageResponseModelImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;
import com.iselect.kernal.pageflow.model.PageResponseModel;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;

/**
 *
 * @author Hiep
 */
@Repository
public class PageResponseDaoImpl extends ISelectDaoAbst<PageResponseModel> implements PageResponseDao<PageResponseModel> {

    /**
     * Save all PageResponse objects.
     *
     * @param responseModels
     * @return list of unsaved PageResponse objects
     */
    @Override
    public List<PageResponseModel> savePageResponse(List<? extends PageResponseModel> responseModels) {
        List<PageResponseModel> unsavedList = new ArrayList<>();
        for (PageResponseModel pageResponse : responseModels) {
            try {
                savePagResponse(pageResponse);
            } catch (RuntimeException | ISelectDaoException re) {
                Logger.getLogger(PageResponseDaoImpl.class.getName()).log(Level.SEVERE, null, re);
                unsavedList.add(pageResponse);
            }
        }
        return unsavedList;
    }

    @Override
    public PageResponseModel savePagResponse(PageResponseModel responseModel) throws ISelectDaoException {
        if (responseModel == null) {
            return null;
        }
        PageResponseModel model = this.getPageResponse(responseModel.getRequest().getId(), responseModel.getResultTitle());

        /*the model existing in database, so we do nothing*/
        if (model != null) {
            return model;
        }

        return this.saveOrUpdate(responseModel);
    }
    
    /**
     * Get all active responses
     * @return
     * @throws ISelectDaoException 
     */
    @Override
    public List<PageResponseModel> getPageResponses() throws ISelectDaoException {
        return em.createNamedQuery(PageResponseModel.QUERY_RESPONSES_BY_STATUS)
                .setParameter(PageResponseModel.PARAM_VFLAG, true)
                .getResultList();
    }

    /**
     * get all responses by PageRequest's Id
     * @param requestId
     * @return
     * @throws ISelectDaoException 
     */
    @Override
    public List<PageResponseModel> getPageResponses(Long requestId) throws ISelectDaoException {
        return em.createNamedQuery(PageResponseModel.QUERY_RESPONSES_BY_REQUEST_ID)
                .setParameter(PageResponseModel.PARAM_REQUEST, new PageRequestModelImpl(requestId))
                .getResultList();
    }

    @Override
    public PageResponseModel getPageResponse(Long id) throws ISelectDaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public PageResponseModel getPageResponse(Long requestId, String resultTitle) throws ISelectDaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updatePageResponse(PageResponseModel response) throws ISelectDaoException {
        throw new UnsupportedOperationException();
    }

}
