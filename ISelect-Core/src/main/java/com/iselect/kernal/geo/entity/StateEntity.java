/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo.entity;

import com.iselect.kernal.BaseEntity;

/**
 *
 * @author Hiep
 */
public interface StateEntity<T extends CountryEntity> extends BaseEntity{

    String getStateCode();
    void setStateCode(String code);
    
    String getStateName();
    void setStateName(String name);
    
    T getCountry();
    void setCountry(T country);
}
