/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.exception;

/**
 *
 * @author Hiep
 */
public class CopyPropertiesException extends Exception{

    public CopyPropertiesException() {
    }

    public CopyPropertiesException(String message) {
        super(message);
    }

    public CopyPropertiesException(String message, Throwable cause) {
        super(message, cause);
    }

    public CopyPropertiesException(Throwable cause) {
        super(cause);
    }

    public CopyPropertiesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
