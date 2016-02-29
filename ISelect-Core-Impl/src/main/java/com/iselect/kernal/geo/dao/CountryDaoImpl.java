/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo.dao;

import com.iselect.kernal.ISelectDaoAbst;
import com.iselect.kernal.exception.EntityNotFoundException;
import com.iselect.kernal.geo.model.CountryModel;
import com.iselect.kernal.geo.model.CountryModelImpl;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hiep
 */
@Repository
public class CountryDaoImpl extends ISelectDaoAbst<CountryModel> implements CountryDao<CountryModel> {
    
    
    @Override
    public CountryModel getCountryById(Long id) throws EntityNotFoundException {
        CountryModel model=null;
        Query query = this.em.createNamedQuery("country.findById", CountryModelImpl.class);
        query.setParameter("id", id);
        try{
            model=(CountryModel)query.getSingleResult();
        }catch(NoResultException nre){
            throw new EntityNotFoundException(id.toString(), nre);
        }
        return model;
    }

    @Override
    public CountryModel getCountryByCode(String code) throws EntityNotFoundException {
        CountryModel country = null;
        Query query = em.createNamedQuery("country.findByCode", CountryModelImpl.class);
        query.setParameter("countryCode", code);
        try{
            country=(CountryModel)query.getSingleResult();
        }catch(NoResultException nre){
            throw new EntityNotFoundException(code, nre);
        }
        return country;
    }

    @Override
    public List<CountryModel> getCountries() {
        Query query = this.em.createNamedQuery("country.findAll", CountryModelImpl.class);
        return query.getResultList();
    }
    
    @Override
    public List<CountryModel> getCountriesByName(String name) {
        Query query = em.createNamedQuery("country.findByName", CountryModelImpl.class);
        query.setParameter("countryName", name);
        return query.getResultList();
    }

    @Override
    public void insertCountry(CountryModel country) {
        this.em.persist(country);
    }

    @Override
    public void updateCountry(CountryModel country) {
        this.em.merge(country);
    }

    @Override
    public void deleteCountry(CountryModel country) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
