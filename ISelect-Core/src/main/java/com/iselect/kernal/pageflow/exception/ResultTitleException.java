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
public class ResultTitleException extends Exception{

    public ResultTitleException() {
    }

    public ResultTitleException(String message) {
        super(message);
    }

    public ResultTitleException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResultTitleException(Throwable cause) {
        super(cause);
    }

    public ResultTitleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
