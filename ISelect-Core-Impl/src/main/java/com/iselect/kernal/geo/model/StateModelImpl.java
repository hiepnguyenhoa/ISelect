/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo.model;

import com.iselect.kernal.geo.entity.StateEntityImpl;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hiep
 */
@Entity
@Table(name = "GEO_STATE")
@XmlRootElement
public class StateModelImpl extends StateEntityImpl<CountryModelImpl> implements StateModel<CountryModelImpl> {
    
}
