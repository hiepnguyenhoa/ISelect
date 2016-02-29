/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal;

import com.iselect.kernal.account.dto.AuthorityDto;
import com.iselect.kernal.account.dto.AuthorityDtoImpl;
import com.iselect.kernal.account.dto.UserDto;
import com.iselect.kernal.account.dto.UserDtoImpl;
import com.iselect.kernal.account.dto.UserProfileDto;
import com.iselect.kernal.account.dto.UserProfileDtoImpl;
import com.iselect.kernal.pageflow.dto.PageRequestDto;
import com.iselect.kernal.pageflow.dto.PageRequestDtoImpl;
import com.iselect.kernal.pageflow.dto.PageResponseDto;
import com.iselect.kernal.pageflow.dto.PageResponseDtoImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Hiep
 */
@Component
@Qualifier("dtoFactory")
public class ISelectDtoFactory implements ISelectFactory {

    @Override
    public UserDto createUser() {
        return new UserDtoImpl();
    }

    @Override
    public UserProfileDto createUserProfile() {
        return new UserProfileDtoImpl();
    }

    @Override
    public AuthorityDto createAuthority() {
        return new AuthorityDtoImpl();
    }

    @Override
    public PageRequestDto createPageRequest() {
        return new PageRequestDtoImpl();
    }

    @Override
    public PageResponseDto createPageResponse() {
        return new PageResponseDtoImpl();
    }

}
