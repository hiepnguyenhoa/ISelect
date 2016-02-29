/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.account.entity;

import com.iselect.kernal.BaseEntityImpl;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Hiep
 * @param <A>
 * @param <P>
 */
@MappedSuperclass
public abstract class UserProfileEntityImpl extends BaseEntityImpl implements UserProfileEntity{

    protected String suffix;
    protected String firstName;
    protected String lastName;
    protected String middleName;
    
//    @NotNull
    protected String email;
    
    @Override
    public String getSuffix(){
        return this.suffix;
    }
    
    @Override
    public void setSuffix(String suffix){
        this.suffix=suffix;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getMiddleName() {
        return middleName;
    }

    @Override
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }


}
