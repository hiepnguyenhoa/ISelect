/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.entity;

import com.iselect.kernal.BaseEntity;

/**
 *
 * @author Hiep
 */
public interface PhoneNumberEntity extends BaseEntity{
    public String getPhoneNumber();
    public void setPhoneNumber(String phone);
    
    public byte getType();
    public void setType(byte type);
}
