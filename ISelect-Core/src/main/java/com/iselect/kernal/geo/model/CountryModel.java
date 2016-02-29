/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo.model;

import com.iselect.kernal.BaseModel;
import com.iselect.kernal.geo.entity.CountryEntity;

/**
 *
 * @author Hiep
 * @param <T>
 */
public interface CountryModel<T extends StateModel> extends CountryEntity<T>, BaseModel {
    
}
