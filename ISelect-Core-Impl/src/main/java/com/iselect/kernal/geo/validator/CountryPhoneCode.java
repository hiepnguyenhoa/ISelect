/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;

/**
 *
 * @author Hiep
 */
@Size(min=3, max=5)
@Constraint(validatedBy = CountryPhoneCodeValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CountryPhoneCode {
    String message() default "{err.geo.country.phone.code}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
