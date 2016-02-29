/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo.service.test;

import com.iselect.kernal.geo.dto.CountryDto;
import com.iselect.kernal.geo.dto.CountryDtoImpl;
import com.iselect.kernal.geo.service.GeographicServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

/**
 *
 * @author Hiep
 */
public class GeographicServiceTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("@Before");
    }

    @Test
    public void testImportGeos() {
        List<CountryDto> countries = new ArrayList<>();
        CountryDto country = null;
        for (int i = 0; i < 0; i++) {
            country = new CountryDtoImpl();
            country.setCountryCode("cd_"+i);
            country.setCountryName("CN_" + i);
            country.setPhoneCode("PC_"+i);
            countries.add(country);
        }
        GeographicServiceImpl geoService = new GeographicServiceImpl();
        geoService.importGeos(countries);
    }
    
    public static void main(String[] args) {
        org.junit.runner.Result result = JUnitCore.runClasses(GeographicServiceTest.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }
}
