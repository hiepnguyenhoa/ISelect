/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo.dao;

import com.iselect.kernal.ISelectDao;
import com.iselect.kernal.exception.EntityNotFoundException;
import com.iselect.kernal.geo.model.CountryModel;
import java.util.List;

/**
 *
 * @author Hiep
 * @param <T>
 */
public interface CountryDao<T extends CountryModel> extends ISelectDao<T> {
    
    T getCountryById(Long id) throws EntityNotFoundException;
    T getCountryByCode(String code) throws EntityNotFoundException;
    List<T> getCountries();
    List<T> getCountriesByName(String name);
    
    void insertCountry(CountryModel country);
    void updateCountry(CountryModel country);
    void deleteCountry(CountryModel country);
}
