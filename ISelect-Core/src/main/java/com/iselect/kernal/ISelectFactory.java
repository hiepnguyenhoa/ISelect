/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal;

import com.iselect.kernal.account.entity.AuthorityEntity;
import com.iselect.kernal.account.entity.UserEntity;
import com.iselect.kernal.account.entity.UserProfileEntity;
import com.iselect.kernal.pageflow.dto.PageRequestDto;
import com.iselect.kernal.pageflow.dto.PageResponseDto;
import com.iselect.kernal.pageflow.entity.PageRequestEntity;
import com.iselect.kernal.pageflow.entity.PageResponseEntity;

/**
 *
 * @author Hiep
 */
public interface ISelectFactory {
    public <T extends UserEntity> T createUser();
    public <T extends UserProfileEntity> T createUserProfile();
    public <T extends AuthorityEntity> T createAuthority();

    public <T extends PageRequestEntity> T createPageRequest();

    public <T extends PageResponseEntity> T createPageResponse();

}
