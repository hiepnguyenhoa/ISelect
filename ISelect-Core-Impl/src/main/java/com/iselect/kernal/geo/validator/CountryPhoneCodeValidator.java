/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Hiep
 */
public class CountryPhoneCodeValidator implements ConstraintValidator<CountryPhoneCode, String> {

    @Override
    public void initialize(CountryPhoneCode a) {

    }

    @Override
    public boolean isValid(String t, ConstraintValidatorContext cvc) {
        if(t==null) return false;
        t=t.trim();
        if (t.startsWith("(")&&t.endsWith(")"))
                return true;
        return false;
    }
    
}
