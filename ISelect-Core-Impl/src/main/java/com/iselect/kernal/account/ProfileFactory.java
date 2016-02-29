/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.account;

import com.iselect.kernal.EntityType;
import com.iselect.kernal.account.dto.UserProfileDtoImpl;
import com.iselect.kernal.account.entity.UserProfileEntity;
import com.iselect.kernal.account.model.UserProfileModelImpl;

/**
 *
 * @author Hiep
 */
public class ProfileFactory {
    public static UserProfileEntity createUserProfile(EntityType type){
        UserProfileEntity entity=null;
        switch (type) {
            case MODEL:
                entity = new UserProfileModelImpl();
                break;
            case DTO:
                entity = new UserProfileDtoImpl();
                break;
        }
        return entity;
    }
}
