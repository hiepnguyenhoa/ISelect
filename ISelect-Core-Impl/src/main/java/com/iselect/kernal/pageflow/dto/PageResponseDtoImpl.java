/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.dto;

import com.iselect.kernal.pageflow.entity.PageResponseEntityImpl;


public class PageResponseDtoImpl extends PageResponseEntityImpl<PageRequestDtoImpl> implements PageResponseDto<PageRequestDtoImpl> {

    private long returnPathId;

    @Override
    public long getReturnPathId() {
        return returnPathId;
    }

    @Override
    public void setReturnPathId(long returnPathId) {
        this.returnPathId = returnPathId;
    }

    
}
