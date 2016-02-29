package com.iselect.kernal.entity;

import com.iselect.kernal.BaseEntity;

public interface AddressEntity extends BaseEntity {

    public String getAddress1();

    public void setAddress1(String address);
    
    public String getAddress2();

    public void setAddress2(String address);
    
    public String getUnit();
    public void setUnit(String unit);

    public String getCity();

    public void setCity(String city);

    public String getState();

    public void setState(String state);

    public String getZipCode();

    public void setZipCode(String zipCode);
}
