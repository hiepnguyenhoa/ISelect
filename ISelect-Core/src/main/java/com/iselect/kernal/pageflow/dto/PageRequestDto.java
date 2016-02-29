/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.dto;

import com.iselect.kernal.BaseDto;
import java.util.List;
import com.iselect.kernal.pageflow.entity.PageRequestEntity;

/**
 *
 * @author Hiep
 * @param <T>
 */
public interface PageRequestDto<T extends PageResponseDto> extends BaseDto, PageRequestEntity<T>{
    public String getClazzShortName();
    
    
}
