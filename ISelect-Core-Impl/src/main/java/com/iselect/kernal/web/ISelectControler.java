/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.web;

import com.iselect.kernal.ISelectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Hiep
 */
public class ISelectControler {
    
    @Autowired
    @Qualifier("dtoFactory")
    protected ISelectFactory dtoFactory;
    
    public static final String CRUD_MODEL = "crudMode";
    
    @ModelAttribute(CRUD_MODEL)
    protected boolean defaultCrudMode(){
        return ISelectCRUDModel.VIEW.isReadOnly();
    }
}
