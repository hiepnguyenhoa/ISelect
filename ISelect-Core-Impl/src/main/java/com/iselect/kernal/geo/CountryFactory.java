/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo;

import com.iselect.kernal.EntityType;
import com.iselect.kernal.geo.dto.CountryDtoImpl;
import com.iselect.kernal.geo.entity.CountryEntity;
import com.iselect.kernal.geo.model.CountryModelImpl;

/**
 *
 * @author Hiep
 */
public class CountryFactory{

    public static CountryEntity createCountry(EntityType type) {
        CountryEntity entity=null;
        switch (type) {
            case MODEL:
                entity = new CountryModelImpl();
                break;
            case DTO:
                entity = new CountryDtoImpl();
                break;
        }
        return entity;
    }
    
}
