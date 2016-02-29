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
public class PageFlowRequestNotFoundException extends Exception{

    public PageFlowRequestNotFoundException() {
    }

    public PageFlowRequestNotFoundException(String message) {
        super(message);
    }

    public PageFlowRequestNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PageFlowRequestNotFoundException(Throwable cause) {
        super(cause);
    }

    public PageFlowRequestNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
