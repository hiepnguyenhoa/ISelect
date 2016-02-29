/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.account.model;

import com.iselect.kernal.BaseModel;
import com.iselect.kernal.account.entity.UserEntity;

/**
 *
 * @author Hiep
 * @param <U>
 * @param <A>
 */
public interface UserModel<U extends UserProfileModel, A extends AuthorityModel> extends UserEntity<U, A>, BaseModel{
    
}
