/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.account.entity;

import com.iselect.kernal.BaseEntity;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Hiep
 */
public interface AuthorityEntity extends BaseEntity, GrantedAuthority {

    @Override
    public String getAuthority();

    public void setAuthority(String authority);
}
