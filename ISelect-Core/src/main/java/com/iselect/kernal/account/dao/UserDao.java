/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.account.dao;

import com.iselect.kernal.ISelectCrudDao;
import com.iselect.kernal.account.model.UserModel;
import java.util.List;

/**
 *
 * @author Hiep
 * @param <T>
 */
public interface UserDao{

    List<UserModel> findByFirstName(String firstName);

    List<UserModel> findByFirstNameAndLastName(String firstName, String lastName);

    public UserModel getByUserName(String userName);

}
