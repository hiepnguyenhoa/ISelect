/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo.entity;

import com.iselect.kernal.BaseEntityImpl;
import com.iselect.kernal.geo.validator.CountryPhoneCode;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Hiep
 */
@MappedSuperclass
public class CountryEntityImpl<T extends StateEntity> extends BaseEntityImpl implements CountryEntity<T> {
    
    @Column(name="CODE")
    @NotNull
    private String countryCode;
    
    @Column(name="NAME")
    @Size(min=5, max=20)
    private String countryName;
    
    @CountryPhoneCode
    private String phoneCode;
    
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @OrderBy("code ASC")
    private List<T> states = new ArrayList<>();

    @Override
    public String getCountryCode() {
        return this.countryCode;
    }

    @Override
    public void setCountryCode(String code) {
        this.countryCode=code;
    }

    @Override
    public String getCountryName() {
        return countryName;
    }

    @Override
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    @Override
    public List<T> getStates() {
        return this.states;
    }

    @Override
    public void setState(List<T> states) {
        this.states=states;
    }

    @Override
    public void addState(T state) {
        this.states.add(state);
    }
    
}
