/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.web.controller.admin;

import com.iselect.kernal.exception.CopyPropertiesException;
import com.iselect.kernal.exception.EntityNotFoundException;
import com.iselect.kernal.geo.dto.CountryDto;
import com.iselect.kernal.geo.dto.CountryDtoImpl;
import com.iselect.kernal.geo.dto.StateDto;
import com.iselect.kernal.geo.dto.StateDtoImpl;
import com.iselect.kernal.geo.model.StateModel;
import com.iselect.kernal.geo.service.GeographicService;
import com.iselect.kernal.web.ISelectCRUDModel;
import com.iselect.kernal.web.ISelectControler;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Hiep
 */
@Controller
@RequestMapping(value = "/geo")
public class GeographicController extends ISelectControler{
    
    public static final String ENTITY_ID   = "states";
    public static final String COUNTRY  = "country";
    public static final String COUNTRIES    = "countries";
    public static final String STATE    = "state";
    public static final String STATES   = "states";
    
    @Autowired
    private GeographicService geoService;
    
    @RequestMapping(value={"/country/index", "/country"})
    public String getContries(Model model){
        model.addAttribute(COUNTRIES, geoService.getCountries());
        return "geo.index";
    }
    
    @RequestMapping(value="/country/new", method = RequestMethod.GET)
    public String newCountry(Model model){
        model.addAttribute(CRUD_MODEL, ISelectCRUDModel.EDIT.isReadOnly());
        return "geo.country";
    }
    
    @RequestMapping(value="/country/new", method = RequestMethod.POST)
    public String newCountry(@Valid @ModelAttribute(COUNTRY) CountryDto country, BindingResult results, Model model){
        if(results.hasErrors()){
            model.addAttribute(CRUD_MODEL, ISelectCRUDModel.EDIT.isReadOnly());
            return "geo.country";
        }
        geoService.saveCountry(country);
        return "redirect:./";
    }
    
    @RequestMapping(value="/country/edit/{id}", method = RequestMethod.GET)
    public String editCountry(@PathVariable Long id, Model model) throws EntityNotFoundException, CopyPropertiesException{
        CountryDto country = geoService.getCountry(id);
        model.addAttribute(COUNTRY, country);
        model.addAttribute(CRUD_MODEL, ISelectCRUDModel.EDIT.isReadOnly());
        return "geo.country";
    }
    
    @RequestMapping(value="/country/edit/{id}", method = RequestMethod.POST)
    public String editCountry(@Valid @ModelAttribute(COUNTRY) CountryDto country, BindingResult  results, Model model) throws EntityNotFoundException, CopyPropertiesException{
        if(results.hasErrors()){
            model.addAttribute(CRUD_MODEL, ISelectCRUDModel.EDIT.isReadOnly());
            return "geo.country";
        }
        geoService.updateCountry(country);
        return "redirect:../";
    }
    
    @RequestMapping(value="/country/view/{id}", method = RequestMethod.GET)
    public String viewCountry(@PathVariable Long id, Model model) throws EntityNotFoundException, CopyPropertiesException{
        CountryDto country = geoService.getCountry(id);
        model.addAttribute(COUNTRY, country);
        return "geo.country";
    }
    
    @ModelAttribute("country")
    public CountryDto initCountry(){
        return new CountryDtoImpl();
    }
    
    @RequestMapping(value="/country/{countryId}/state/new", method=RequestMethod.GET)
    public String newState(@PathVariable Long countryId, Model model) throws EntityNotFoundException, CopyPropertiesException{
        model.addAttribute(COUNTRY,geoService.getCountry(countryId));
        return "geo.state";
    }
    
    @RequestMapping(value="/country/{countryId}/state/new", method=RequestMethod.POST)
    public String newState(@Valid @ModelAttribute("state") StateDto state, BindingResult result, Model model) throws EntityNotFoundException, CopyPropertiesException{
        if(result.hasErrors()){
            model.addAttribute(CRUD_MODEL, ISelectCRUDModel.EDIT.isReadOnly());
            return "geo.state";
        }
        geoService.saveState(state);
        return "redirect:/geo/country/view/" + state.getCountry().getId();
    }
    
    @ModelAttribute("state")
    public StateDto initState(){
        return new StateDtoImpl();
    }
    
    @ExceptionHandler(EntityNotFoundException.class)
    public String entityNotFound(){
        return "geo.notfound";
    }
    
    @RequestMapping(value="/import", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseEntity<List<Future>> importGeos(@RequestBody List<CountryDtoImpl> countries){
        List<Future> results = this.geoService.importGeos(countries);
        return new ResponseEntity<>(results, null, null);
    }
    
    @RequestMapping("/export")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CountryDto> exportGeos(){
        return this.geoService.getCountries();
    }
}
