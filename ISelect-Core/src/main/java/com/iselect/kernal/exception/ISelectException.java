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
public class ISelectException extends Exception{

    public ISelectException() {
    }

    public ISelectException(String message) {
        super(message);
    }

    public ISelectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ISelectException(Throwable cause) {
        super(cause);
    }

    public ISelectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
