/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.web.controller;

import com.iselect.kernal.exception.CopyPropertiesException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Hiep
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(CopyPropertiesException.class)
    public String copyPropertyException(CopyPropertiesException ex){
        Logger.getLogger(GlobalExceptionHandler.class.getName()).log(Level.SEVERE, null, ex);
        return "global.exception.copyproperties";
    }
}
