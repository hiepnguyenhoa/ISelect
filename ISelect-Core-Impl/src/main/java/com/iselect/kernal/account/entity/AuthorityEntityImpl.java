/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.account.entity;

import com.iselect.kernal.BaseEntityImpl;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Hiep
 */

@MappedSuperclass
public class AuthorityEntityImpl extends BaseEntityImpl implements AuthorityEntity{

    @Column(name="NAME")
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    
}
