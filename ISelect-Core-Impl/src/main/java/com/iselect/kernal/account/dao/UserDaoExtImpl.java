/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.account.dao;

import com.iselect.kernal.ISelectDaoAbst;
import com.iselect.kernal.account.model.UserModelImpl;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hiep
 */
@Repository
public class UserDaoExtImpl extends ISelectDaoAbst<UserModelImpl> implements UserDaoExt<UserModelImpl> {

    protected UserModelImpl find(Long id) {
//        return em.find( UserModelImpl.class, id);
        return null;
    }

    @Override
    public UserModelImpl getByUserName(String username) {
        Query query = em.createNamedQuery(UserModelImpl.GET_BY_USERNAME, UserModelImpl.class);
        query.setParameter(UserModelImpl.PARAM_USERNAME, username);
        return (UserModelImpl)query.getSingleResult();
    }

    @Override
    public void save(UserModelImpl user) {
        em.persist(user);
    }
}
