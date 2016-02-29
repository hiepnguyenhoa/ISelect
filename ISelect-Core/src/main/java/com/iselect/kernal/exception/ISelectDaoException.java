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
public class ISelectDaoException extends Exception{

    public ISelectDaoException() {
    }

    public ISelectDaoException(String message) {
        super(message);
    }

    public ISelectDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ISelectDaoException(Throwable cause) {
        super(cause);
    }

    public ISelectDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
