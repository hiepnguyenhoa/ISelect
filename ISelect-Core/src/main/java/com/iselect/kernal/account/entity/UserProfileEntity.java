/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.account.entity;

import com.iselect.kernal.BaseEntity;
import com.iselect.kernal.entity.AddressEntity;
import com.iselect.kernal.entity.PhoneNumberEntity;
import java.util.List;

/**
 *
 * @author Hiep
 * @param <T extends AddressEntity>
 * @param <P extends PhoneNumberEntity>
 */
public interface UserProfileEntity extends BaseEntity{
    
    public String getSuffix();
    public void setSuffix(String suffix);
    
    public String getFirstName();
    public void setFirstName(String firstName);
    
    public String getLastName();
    public void setLastName(String lastName);
    
    public String getMiddleName();
    public void setMiddleName(String middleName);
    
    public String getEmail();
    public void setEmail(String email);
//    
//    public List<T> getAddresses();
//    public void setAddresses(List<T> addresses);
//    public void addAddress(T address);
//    public T rmvAddress(T address);
//    
//    public List<P> getPhoneNumbers();
//    public void setPhoneNumbers(List<P> phones);
//    public void addPhoneNumber(P phone);
//    public P rmvPhoneNumber(P phone);
}
