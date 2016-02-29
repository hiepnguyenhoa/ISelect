/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.dao;

import com.iselect.kernal.ISelectDaoAbst;
import com.iselect.kernal.exception.ISelectDaoException;
import com.iselect.kernal.pageflow.model.PageRequestModelImpl;
import com.iselect.kernal.pageflow.entity.PageFlowRequestType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMethod;
import com.iselect.kernal.pageflow.model.PageRequestModel;
import javax.persistence.Query;

/**
 *
 * @author Hiep
 */
@Repository
public class PageRequestDaoImpl extends ISelectDaoAbst<PageRequestModel> implements PageRequestDaoExt<PageRequestModel> {

    /**
     * Checking whether the request path is existing in database then return it.
     *
     * @param requestModel
     * @return
     * @throws ISelectDaoException
     */
    @Override
    public PageRequestModel savePageRequest(PageRequestModel requestModel) throws ISelectDaoException {

        PageRequestModel request = this.getPageRequest(requestModel.getActionPath(), requestModel.getActionMethod());

        /*existing the object in database => do nothing*/
        if (request != null) {
            return request;
        }

        em.persist(request);

        return request;
    }

    @Override
    public PageRequestModel getPageRequest(String actionPath, RequestMethod actionMethod) throws ISelectDaoException {
        return getPageRequest(actionPath, actionMethod.name());
    }

    @Override
    public PageRequestModel getPageRequest(String actionPath, String actionMethod) throws ISelectDaoException {
        Query query = em.createNamedQuery(PageRequestModel.QUERY_BY_PATH_METHOD);
        query.setParameter(PageRequestModel.PARAM_ACTION_METHOD, actionPath);
        query.setParameter(PageRequestModel.PARAM_ACTION_METHOD, actionMethod);
        return (PageRequestModel) query.getSingleResult();
    }

    /**
     * Get all valid requests.
     * @return
     * @throws ISelectDaoException
     */
    @Override
    public List<? extends PageRequestModel> getPageRequests() throws ISelectDaoException {
        return em.createNamedQuery(PageRequestModel.QUERY_BY_STATUSFLAG)
                .setParameter(PageRequestModel.PARAM_VFLAG,true)
                .getResultList();        
    }

    @Override
    public List<? extends PageRequestModel> getPageRequests(PageFlowRequestType type) throws ISelectDaoException {
//        String sql = formatSql(GET_REQUEST, PageRequestModelImpl.class);
//        Map<String, Object> params = new HashMap<>();
//        switch (type) {
//            case GET:
//            case POST:
//                sql += condByMethod();
//                params.put("actionMethod", type.getText());
//                break;
//        }
//        return this.get(sql, params);
        throw new UnsupportedOperationException();
    }

    @Override
    public List<? extends PageRequestModel> getPageFlowRequestsOrderBySecurityOrder() throws ISelectDaoException {
        throw new UnsupportedOperationException();
    }

    //
    @Override
    public void updateSecurityOrder(PageRequestModel request) throws ISelectDaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<PageRequestModel> savePageFlowRequest(List<? extends PageRequestModel> pageFlowModels) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PageRequestModel getPageFlowRequest(Long id) throws ISelectDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
