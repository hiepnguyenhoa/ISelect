/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.account.dto;

import com.iselect.kernal.BaseDto;

/**
 *
 * @author Hiep
 */
public class GrantedAuthorityDtoImpl implements BaseDto {

    private final String authority;
    
    public GrantedAuthorityDtoImpl(String authority){
        this.authority=authority;
    }

    public String getAuthority() {
        return authority;
    }
    
    
}
