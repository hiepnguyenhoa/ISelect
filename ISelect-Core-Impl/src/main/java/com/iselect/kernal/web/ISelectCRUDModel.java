/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.web;

/**
 *
 * @author Hiep
 */
public enum ISelectCRUDModel {
    EDIT(false), VIEW(true);
    
    private boolean readOnly;
    
    ISelectCRUDModel(boolean readOnly){
        this.readOnly=readOnly;
    }
    
    public boolean isReadOnly(){
        return this.readOnly;
    }
}
