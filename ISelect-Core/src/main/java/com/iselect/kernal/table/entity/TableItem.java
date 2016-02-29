/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.table.entity;

import java.time.LocalDateTime;

/**
 *
 * @author Hiep
 */
public interface TableItem extends TableElement{
    
    public void setItemKey(String itemKey);
    public String getItemKey();
    
    public void setValidFrom(LocalDateTime date);
    public LocalDateTime getValidFrom();
    
    public void setValidTo(LocalDateTime date);
    public LocalDateTime getValidTo();
    
}
