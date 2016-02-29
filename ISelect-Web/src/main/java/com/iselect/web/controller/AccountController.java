/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.web.controller;

import com.iselect.kernal.account.dto.UserDto;
import com.iselect.kernal.account.service.AccountService;
import com.iselect.kernal.exception.EntityNotFoundException;
import com.iselect.kernal.web.ISelectControler;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Hiep
 */
@Controller
@RequestMapping("/account")
public class AccountController extends ISelectControler{
    
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String indexAccount(ModelAndView model) {
        return "account.index";
    }
    
    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    
    public String newAccount(Model model) {
        model.addAttribute("action", "new");
        return "account.details";
    }
    
    @RequestMapping(value="/new", method=RequestMethod.POST)
    public String postAccount(@ModelAttribute(value = "account") @Valid  UserDto userDto, BindingResult results) throws EntityNotFoundException{
        if(results.hasErrors())
            return "account.details";
        
        accountService.insertOrUpdateUser(userDto);
        
        return"redirect:./index";
    }
    
    @ModelAttribute("account")
    public UserDto getUseDto(){
        return dtoFactory.createUser();
    }
}
