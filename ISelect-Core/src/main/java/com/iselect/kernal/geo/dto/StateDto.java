/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo.dto;

import com.iselect.kernal.BaseDto;
import com.iselect.kernal.geo.entity.StateEntity;

/**
 *
 * @author Hiep
 * @param <T>
 */
public interface StateDto<T extends CountryDto> extends StateEntity<T>, BaseDto{
    
}
