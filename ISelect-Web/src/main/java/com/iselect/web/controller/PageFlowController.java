/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.web.controller;

import com.iselect.kernal.ISelectControllerAbst;
import com.iselect.kernal.exception.ISelectException;
import com.iselect.kernal.pageflow.annotation.ResultTitle;
import com.iselect.kernal.pageflow.annotation.ResultTitleType;
import com.iselect.kernal.pageflow.dao.PageResponseDao;
import com.iselect.kernal.pageflow.dto.PageRequestDtoImpl;
import com.iselect.kernal.pageflow.service.PageFlowService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.iselect.kernal.pageflow.dto.PageRequestDto;
import com.iselect.kernal.pageflow.dto.PageResponseDto;
import com.iselect.kernal.pageflow.dto.PageResponseDtoImpl;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Hiep
 */
@Controller
@RequestMapping("/pageflow")
public class PageFlowController extends ISelectControllerAbst {

    @Autowired
    private PageFlowService pageFlowService;

    @RequestMapping
    public String get(Model model) {
        return "pageflow.index";
    }

    @RequestMapping(value = {"/list"})
    public String listPageFlow(Model model) throws ISelectException {
        model.addAttribute(MODEL_PAGE_REQUESTS, pageFlowService.getPageFlowRequests());
        return "pageflow.list";
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public String editPageFlow(@PathVariable("id") long id, Model model) {
        PageRequestDto requestDto = this.pageFlowService.getPageRequest(id);
        model.addAttribute(MODEL_PAGE_REQEST, requestDto);
        return "pageflow.edit";
    }

    @RequestMapping(value = {"/edit{id}"}, method = RequestMethod.POST)
    public String editPageFlow(@Valid @ModelAttribute(MODEL_PAGE_REQEST) PageRequestDto pageRequest, BindingResult results) {
        if(results.hasErrors()) return "pageflow.edit";
        pageFlowService.updatePageResponses(pageRequest);
        return "redirect:./list";
    }

    @RequestMapping(value = {"/parser"}, method = RequestMethod.GET)
    public String paser(HttpServletRequest request) {
        return "pageflow.parser";
    }

    @RequestMapping(value = {"/parser"}, method = RequestMethod.POST)
    public String getPathAndAction(@RequestParam("packName") String packageName, HttpServletRequest request) {
        pageFlowService.parseControllers(packageName);
        return "redirect:./list";
    }

    @ModelAttribute(MODEL_PAGE_REQEST)
    public PageRequestDto initPageRequestDto() {
        return new PageRequestDtoImpl();
    }

    @ModelAttribute(MODEL_PAGE_RESPONSE)
    public PageResponseDto initPageResponseDto() {
        return new PageResponseDtoImpl();
    }
    
}
