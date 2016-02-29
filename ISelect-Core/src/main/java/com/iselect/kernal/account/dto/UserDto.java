/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.account.dto;

import com.iselect.kernal.BaseDto;
import com.iselect.kernal.account.entity.UserEntity;

/**
 *
 * @author Hiep
 * @param <U>
 * @param <A>
 */
public interface UserDto<U extends UserProfileDto, A extends AuthorityDto> extends UserEntity<U, A> , BaseDto{
    
}
