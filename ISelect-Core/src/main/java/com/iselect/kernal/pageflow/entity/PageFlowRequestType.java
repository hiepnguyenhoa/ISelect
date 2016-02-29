/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.entity;

/**
 *
 * @author Hiep
 */
public enum PageFlowRequestType {
    GET("GET"), POST("POST"), ALL("ALL");
    
    private String text;
    private PageFlowRequestType(String text){
        this.text=text;
    }
    
    public String getText(){
        return text;
    }
}
