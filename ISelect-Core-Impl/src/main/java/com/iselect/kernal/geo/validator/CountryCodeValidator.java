/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo.validator;

import com.iselect.kernal.exception.CopyPropertiesException;
import com.iselect.kernal.exception.EntityNotFoundException;
import com.iselect.kernal.geo.service.GeographicService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Hiep
 */
@Component
public class CountryCodeValidator implements ConstraintValidator<CountryCode, String>{
    
    @Autowired
    private GeographicService geoService;
    
    @Override
    public void initialize(CountryCode countryCode){
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext cvt){
        try {
            geoService.getCountryByCode(value);
        } catch (EntityNotFoundException ex) {
            return true;
        } catch (CopyPropertiesException ex) {
            Logger.getLogger(CountryCodeValidator.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
        return false;
    }
}
