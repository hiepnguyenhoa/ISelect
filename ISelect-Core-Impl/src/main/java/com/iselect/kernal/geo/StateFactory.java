/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.geo;

import com.iselect.kernal.EntityType;
import com.iselect.kernal.geo.dto.StateDtoImpl;
import com.iselect.kernal.geo.entity.StateEntity;
import com.iselect.kernal.geo.model.StateModelImpl;

/**
 *
 * @author Hiep
 */
public class StateFactory {
    
    public static StateEntity createState(EntityType type) {
        StateEntity entity=null;
        switch (type) {
            case MODEL:
                entity = new StateModelImpl();
                break;
            case DTO:
                entity = new StateDtoImpl();
                break;
        }
        return entity;
    }
}
