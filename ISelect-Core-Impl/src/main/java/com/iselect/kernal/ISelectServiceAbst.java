/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author Hiep
 */
public class ISelectServiceAbst implements ISelectService
{
    @Autowired
    @Qualifier("modelFactory")
    protected ISelectFactory modelFactory;
    
    @Autowired
    @Qualifier("dtoFactory")
    protected ISelectFactory dtoFactory;
    
}
