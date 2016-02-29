/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.dto;

import com.iselect.kernal.BaseDto;
import com.iselect.kernal.pageflow.entity.PageResponseEntity;

/**
 *
 * @author Hiep
 */
public interface PageResponseDto<T extends PageRequestDto> extends BaseDto, PageResponseEntity<T>{

    public long getReturnPathId();
    public void setReturnPathId(long returnPathId);
    
}
