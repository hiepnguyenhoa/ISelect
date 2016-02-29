/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo.model;

import com.iselect.kernal.geo.entity.CountryEntityImpl;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hiep
 */
@Entity
@Table(name = "GEO_COUNTRY")
@NamedQueries({
    @NamedQuery(name="country.findAll",
            query = "Select c from CountryModelImpl c"),
    @NamedQuery(name="country.findById",
            query="Select c From CountryModelImpl c where c.id= :id"),
    @NamedQuery(name="country.findByCode",
            query="Select c From CountryModelImpl c where c.countryCode= :countryCode"),
    @NamedQuery(name="country.findByName",
            query="Select c From CountryModelImpl c Where c.countryName= :countryName")
})
@XmlRootElement
public class CountryModelImpl extends CountryEntityImpl<StateModelImpl> implements CountryModel<StateModelImpl> {
    
}
