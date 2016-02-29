/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo.service;

import com.iselect.kernal.ISelectService;
import com.iselect.kernal.exception.CopyPropertiesException;
import com.iselect.kernal.exception.EntityNotFoundException;
import com.iselect.kernal.geo.dto.CountryDto;
import com.iselect.kernal.geo.dto.StateDto;
import java.util.List;
import java.util.concurrent.Future;

/**
 *
 * @author Hiep
 */
public interface GeographicService<T extends CountryDto, S extends StateDto> extends ISelectService {
    public List<T> getCountries();
    public T getCountry(Long countryId) throws EntityNotFoundException, CopyPropertiesException;
    public T getCountryByCode(String code) throws EntityNotFoundException, CopyPropertiesException;
    
    void saveCountry(CountryDto country);
    void updateCountry(CountryDto country) throws CopyPropertiesException, EntityNotFoundException;
    void deleteCountry(CountryDto country);
    
    public List<S> getStates(Long stateId) throws EntityNotFoundException;
    public List<S> getStates(T country) throws EntityNotFoundException;
    
    void saveState(StateDto state) throws EntityNotFoundException, CopyPropertiesException;
    void updateState(StateDto state) throws EntityNotFoundException, CopyPropertiesException;
    void deleteState(StateDto state) throws EntityNotFoundException, CopyPropertiesException;
    
    List<Future> importGeos(List<CountryDto> countries);
}
