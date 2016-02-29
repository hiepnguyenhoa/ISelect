/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo.dto;

import com.iselect.kernal.geo.entity.StateEntityImpl;

/**
 *
 * @author Hiep
 */
public class StateDtoImpl extends StateEntityImpl<CountryDto> implements StateDto<CountryDto>{
    {
        country = new CountryDtoImpl();
    }
}
