/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo.dao;

import com.iselect.kernal.ISelectDao;
import com.iselect.kernal.geo.model.CountryModel;
import com.iselect.kernal.geo.model.StateModel;
import java.util.List;

/**
 *
 * @author Hiep
 */
public interface StateDao<T extends StateModel> extends ISelectDao<T> {
    
    T getStateById(Long id);
    T getStateByName(String name);
    List<T> getStatesByCountry(Long id);
    List<T> getStatesByCountry(CountryModel country);
    
    void insertState(StateModel state);
    void updateState(StateModel state);
    void deleteState(StateModel state);
    
}
