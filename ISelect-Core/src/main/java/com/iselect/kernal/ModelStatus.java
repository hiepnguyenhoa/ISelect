/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal;

/**
 *
 * @author Hiep
 */
public enum ModelStatus {
    INVALID(-1),
    HOLDING(0),
    VALID(1);
    
    private int value;
    
    ModelStatus(int value){
        this.value=value;
    }
    
    public int getValue(){
        return this.value;
    }
}
