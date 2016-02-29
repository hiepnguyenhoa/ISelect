/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.web.rest;

import com.iselect.kernal.geo.dto.CountryDto;
import com.iselect.kernal.geo.dto.CountryDtoImpl;
import com.iselect.kernal.test.TestUser;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hiep
 */
@RestController
public class TestUserController {
    
    @RequestMapping("/getUsers")
    public List<TestUser> getTestUser(){
        List<TestUser> users = new ArrayList<>();
        TestUser _user =null;
        _user = new TestUser();
        _user.setAge(36);
        _user.setName("User_1");
        users.add(_user);
        _user = new TestUser();
        _user.setAge(37);
        _user.setName("User_2");
        users.add(_user);
        _user = new TestUser();
        _user.setAge(38);
        _user.setName("User_3");
        users.add(_user);
        
        return users;
    }
    
    @RequestMapping(value = "/addUser", method=RequestMethod.POST)
    public void addUser(@RequestBody TestUser user){
        System.out.println("********** name : " + user.getName() + " **** age : " + user.getAge() + "\n\r");
    }
    
    @RequestMapping(value = "/addUsers", method=RequestMethod.POST)
    public void addUser(@RequestBody List<TestUser> users){
        System.out.println("**********");
    }
    
    @RequestMapping(value="/import", method = {RequestMethod.POST})
    public ResponseEntity<List<Future>> importGeos(@RequestBody List<CountryDtoImpl> countries){
        System.out.println("-----------------");
        return null;
    }
}
