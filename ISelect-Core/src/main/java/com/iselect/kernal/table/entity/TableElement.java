/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.table.entity;

import com.iselect.kernal.BaseEntity;

/**
 *
 * @author Hiep
 */
public interface TableElement extends BaseEntity{
    
    public void setTableKey(String tableKey);
    public String getTableKey();
    
    public void setName(String name);
    public String getName();
    
    public void setDescription(String description);
    public String getDescription();
    
    public void setClazz(Class clazz);
    public Class getClazz();
    
    @Override
    public int hashCode();
    
    @Override
    public boolean equals(Object object);
}
