/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal;

import java.util.Date;

/**
 *
 * @author Hiep
 */
public interface BaseEntity {
    public static final String PARAM_VFLAG = "vFlag";
    
    public long getId();
    public void setId(long pId);
    
    public int getGroupId();
    public void setGroupId(int id);
    
    public byte getServiceId();
    public void setServiceId(byte id);
    
    public void setValidFlag(boolean valid);
    public boolean isValidFlag();
    
    public void setStatusFlag(int status);
    public int getStatusFlag();
    
    public void setCreatedDate(Date createdDate);
    public Date getCreatedDate();
    
    public void setModifiedDate(Date modifiedDate);
    public Date getModifiedDate();
    
    public void setTransId(String transId);
    public String getTransId();
    
    public void setUserJob(String userJob);
    public String getUserJob();
    
    public int getTransNo();
    public void setTransNo(int transNo);
    
}
