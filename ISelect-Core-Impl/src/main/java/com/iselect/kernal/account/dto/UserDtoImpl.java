/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.account.dto;

import com.iselect.kernal.account.entity.UserEntityImpl;


public class UserDtoImpl
        extends UserEntityImpl<UserProfileDtoImpl, AuthorityDtoImpl>
        implements UserDto<UserProfileDtoImpl, AuthorityDtoImpl> {

}
