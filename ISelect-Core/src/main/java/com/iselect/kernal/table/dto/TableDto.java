/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.table.dto;

import com.iselect.kernal.BaseDto;
import com.iselect.kernal.table.entity.Table;

/**
 *
 * @author Hiep
 * @param <T>
 */
public interface TableDto<T extends TableItemDto> extends BaseDto, Table<T>{
      
}
