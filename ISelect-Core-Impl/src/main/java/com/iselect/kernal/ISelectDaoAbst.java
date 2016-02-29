/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal;

import com.iselect.kernal.dao.listener.ModelUpdateListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Hiep Even with getting, It is seem that we no need transaction but
 * actually underground at DBMS it has a transaction with auto commit is true.
 * It depends on implementation of DBMS. We don't know what is exactly. We must
 * follow standard since we use hibernate crossing BDMS. Session session =
 * this.getSession(); Transaction tx = null; try { tx =
 * session.beginTransaction(); //TODO:
 *
 * tx.commit(); } catch (RuntimeException e) { if (tx != null) { tx.rollback();
 * } throw new PersistentException(e); } finally { closeSession(session); } Here
 * I catch RuntimeException instead of HibernateException to be flexible in
 * using other ORM. Other layers only process PersistentException.
 */
/**
 * @param <T>
 */
public abstract class ISelectDaoAbst<T extends BaseModel> implements ISelectDao<T> {

    @PersistenceContext
    protected EntityManager em;
    
    /**
     * 
     * @param model
     * @return model object if updating
     */
    @Override
    public T saveOrUpdate(T model){
        T tmp = null;
        if(model.getId()==0){
            saveModel(model);
        }else{
            tmp = updateModel(model);
        }
        return tmp;
    }

    @Override
    public void saveModel(T model) {
        em.persist(model);
    }

    @Override
    public T updateModel(T model) {
        return em.merge(model);
    }

}
