/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo.service;

import com.iselect.kernal.EntityType;
import com.iselect.kernal.ISelectControllerAbst;
import com.iselect.kernal.exception.CopyPropertiesException;
import com.iselect.kernal.exception.EntityNotFoundException;
import com.iselect.kernal.geo.CountryFactory;
import com.iselect.kernal.geo.StateFactory;
import com.iselect.kernal.geo.dao.CountryDao;
import com.iselect.kernal.geo.dao.StateDao;
import com.iselect.kernal.geo.dto.CountryDto;
import com.iselect.kernal.geo.dto.StateDto;
import com.iselect.kernal.geo.model.CountryModel;
import com.iselect.kernal.geo.model.StateModel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hiep
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class GeographicServiceImpl extends ISelectControllerAbst implements GeographicService<CountryDto, StateDto> {

    @Autowired
    private CountryDao countryDao;

    @Autowired
    private StateDao stateDao;

    @Override
    //    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<CountryDto> getCountries() {
        List<CountryModel> countryModels = this.countryDao.getCountries();
        List<CountryDto> countryDtos = new ArrayList<>(countryModels.size());
        for (CountryModel countryModel : countryModels) {
            CountryDto countryDto = (CountryDto) CountryFactory.createCountry(EntityType.DTO);
            BeanUtils.copyProperties(countryModel, countryDto);
            countryDtos.add(countryDto);
        }
        return countryDtos;
    }

    @Override
    public CountryDto getCountry(Long countryId) throws EntityNotFoundException {
        CountryModel countryModel = this.countryDao.getCountryById(countryId);
        CountryDto countryDto = (CountryDto) CountryFactory.createCountry(EntityType.DTO);
        BeanUtils.copyProperties(countryModel, countryDto);
        List<StateModel> stateModels = countryModel.getStates();
        for(StateModel stateModel: stateModels){
            StateDto stateDto = (StateDto) StateFactory.createState(EntityType.DTO);
            BeanUtils.copyProperties(stateModel, stateDto);
            countryDto.addState(stateDto);
        }
        return countryDto;
    }
    
    @Override
    public CountryDto getCountryByCode(String code) throws EntityNotFoundException, CopyPropertiesException {
        CountryModel countryModel =  this.countryDao.getCountryByCode(code);
        CountryDto countryDto = (CountryDto)CountryFactory.createCountry(EntityType.DTO);
        BeanUtils.copyProperties(countryModel, countryDto);
        List<StateModel> stateModels = countryModel.getStates();
        for(StateModel stateModel: stateModels){
            StateDto stateDto = (StateDto)StateFactory.createState(EntityType.DTO);
            BeanUtils.copyProperties(stateModel, stateDto);
            countryDto.addState(stateDto);
        }
        return countryDto;
    }

    @Override
    public List<StateDto> getStates(CountryDto country) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveCountry(CountryDto country) {
        CountryModel countryModel = (CountryModel) CountryFactory.createCountry(EntityType.MODEL);
        BeanUtils.copyProperties(country, countryModel);
        List<StateDto> states = country.getStates();
        for (StateDto stateDto : states) {
            StateModel stateModel = (StateModel) StateFactory.createState(EntityType.MODEL);
            BeanUtils.copyProperties(stateDto, stateModel);
            countryModel.addState(stateModel);
        }
        this.countryDao.insertCountry(countryModel);
    }

    @Override
    public void updateCountry(CountryDto country) throws CopyPropertiesException, EntityNotFoundException {
        CountryModel countryModel = (CountryModel) CountryFactory.createCountry(EntityType.MODEL);
        BeanUtils.copyProperties(country, countryModel);
        this.countryDao.updateCountry(countryModel);
    }

    @Override
    public void deleteCountry(CountryDto country) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StateDto> getStates(Long stateId) throws EntityNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveState(StateDto state) throws EntityNotFoundException, CopyPropertiesException {
        CountryModel countryModel = this.countryDao.getCountryById(state.getCountry().getId());
        StateModel stateModel = (StateModel) StateFactory.createState(EntityType.MODEL);
        BeanUtils.copyProperties(state, stateModel);
        stateModel.setCountry(countryModel);
        this.stateDao.insertState(stateModel);
    }

    @Override
    public void updateState(StateDto state) throws EntityNotFoundException, CopyPropertiesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteState(StateDto state) throws EntityNotFoundException, CopyPropertiesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Future> importGeos(List<CountryDto> countries) {
        ExecutorService pools = Executors.newFixedThreadPool(2);
        List<Future> results = new ArrayList<>(countries.size());
        for(CountryDto country:countries){
            Future result = pools.submit(new GeographicCallable(country));
            results.add(result);
        }
        try {
            pools.awaitTermination(1, TimeUnit.MINUTES);
            pools.shutdown();
        } catch (InterruptedException ex) {
            Logger.getLogger(GeographicServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }

    class GeographicCallable implements Callable<String>{
        
        private CountryDto countryDto;

        public GeographicCallable(CountryDto countryDto){
            this.countryDto = countryDto;
        }

        @Override
        public String call() throws Exception {
            saveCountry(countryDto);
            StringBuilder sb = new StringBuilder();
            sb.append("*** insert country: ");
            sb.append("   country_id = ").append(countryDto.getId()).append("\n\r");
            sb.append("   country_name = ").append(countryDto.getCountryName()).append("\n\r");
            System.out.println(sb.toString());
            return sb.toString();
        }
    }
}
