/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.exception;

/**
 *
 * @author Hiep
 */
public class PageFlowResponseNotFoundException extends Exception{

    public PageFlowResponseNotFoundException() {
    }

    public PageFlowResponseNotFoundException(String message) {
        super(message);
    }

    public PageFlowResponseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PageFlowResponseNotFoundException(Throwable cause) {
        super(cause);
    }

    public PageFlowResponseNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
