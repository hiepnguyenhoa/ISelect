/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo.dao;

import com.iselect.kernal.ISelectDaoAbst;
import com.iselect.kernal.geo.model.CountryModel;
import com.iselect.kernal.geo.model.StateModel;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hiep
 */
@Repository
public class StateDaoImpl extends ISelectDaoAbst<StateModel> implements StateDao<StateModel> {

    @Override
    public StateModel getStateById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StateModel getStateByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StateModel> getStatesByCountry(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StateModel> getStatesByCountry(CountryModel country) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertState(StateModel state) {
        em.persist(state);
    }

    @Override
    public void updateState(StateModel state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteState(StateModel state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
