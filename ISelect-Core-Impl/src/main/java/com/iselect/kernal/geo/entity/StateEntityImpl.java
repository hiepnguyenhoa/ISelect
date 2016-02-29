/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo.entity;

import com.iselect.kernal.BaseEntityImpl;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Hiep
 * @param <T>
 */
@MappedSuperclass
public class StateEntityImpl<T extends CountryEntity> extends BaseEntityImpl implements StateEntity<T> {
    
    @Column(name="CODE")
//    @NotNull
    @Size(min = 2, max = 3)
    private String stateCode;
    
    @Column(name="NAME")
//    @NotNull
    @Size(min = 3, max = 100)
    private String stateName;
    
    @ManyToOne
    @JoinColumn(name="COUNTRY_ID")
    protected T country;

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public T getCountry() {
        return this.country;
    }

    @Override
    public void setCountry(T country) {
        this.country=country;
    }
    
    
}
