/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo.entity;

import com.iselect.kernal.BaseEntity;
import java.util.List;

/**
 *
 * @author Hiep
 * @param <T>
 */
public interface CountryEntity<T extends StateEntity> extends BaseEntity {
    String getCountryCode();
    void setCountryCode(String code);
    
    String getCountryName();
    void setCountryName(String name);
    
    String getPhoneCode();
    void setPhoneCode(String code);
    List<T> getStates();
    void setState(List<T> states);
    void addState(T state);
}
