/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.dto;

import com.iselect.kernal.pageflow.entity.PageRequestEntityImpl;
import com.iselect.kernal.util.BeanUtil;

/**
 *
 * @author Hiep
 */
public class PageRequestDtoImpl  extends PageRequestEntityImpl<PageResponseDtoImpl> implements PageRequestDto<PageResponseDtoImpl>{

    
    @Override
    public String getClazzShortName() {
        String[] splits=BeanUtil.getClassShortName(this.getActionClazz());
        return splits[splits.length-1];
    }
    
}
