/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.account.model;

import com.iselect.kernal.account.entity.UserEntityImpl;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Hiep
 */
@Entity
@Table(name = "USER")
@NamedQueries({
    @NamedQuery(name = "getByUserName", query="From UserModelImpl u where u.username= :username")
})
public class UserModelImpl extends UserEntityImpl<UserProfileModelImpl, AuthorityModelImpl> implements UserModel<UserProfileModelImpl, AuthorityModelImpl>{
    public static final String GET_BY_USERNAME = "getByUserName";
    public static final String PARAM_USERNAME = "username";

}
