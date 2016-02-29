/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.account.dao;

import com.iselect.kernal.ISelectDao;
import com.iselect.kernal.account.model.UserModel;

/**
 *
 * @author Hiep
 * @param <T>
 */
public interface UserDaoExt<T extends UserModel> extends ISelectDao<T> {

    public T getByUserName(String userName);
    
    public void save(T user);
    
}
