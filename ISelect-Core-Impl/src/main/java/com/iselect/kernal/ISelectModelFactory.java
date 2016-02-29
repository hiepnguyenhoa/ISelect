/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal;

import com.iselect.kernal.account.entity.AuthorityEntity;
import com.iselect.kernal.account.entity.UserEntity;
import com.iselect.kernal.account.entity.UserProfileEntity;
import com.iselect.kernal.account.model.AuthorityModel;
import com.iselect.kernal.account.model.AuthorityModelImpl;
import com.iselect.kernal.account.model.UserModel;
import com.iselect.kernal.account.model.UserModelImpl;
import com.iselect.kernal.account.model.UserProfileModel;
import com.iselect.kernal.account.model.UserProfileModelImpl;
import com.iselect.kernal.pageflow.entity.PageRequestEntity;
import com.iselect.kernal.pageflow.entity.PageResponseEntity;
import com.iselect.kernal.pageflow.model.PageRequestModel;
import com.iselect.kernal.pageflow.model.PageRequestModelImpl;
import com.iselect.kernal.pageflow.model.PageResponseModel;
import com.iselect.kernal.pageflow.model.PageResponseModelImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Hiep
 */
@Component
@Qualifier("modelFactory")
public class ISelectModelFactory implements ISelectFactory {

    @Override
    public UserModel createUser() {
        return new UserModelImpl();
    }

    @Override
    public UserProfileModel createUserProfile() {
        return new UserProfileModelImpl();
    }

    @Override
    public AuthorityModel createAuthority() {
        return new AuthorityModelImpl();
    }

    @Override
    public PageRequestModel createPageRequest() {
        return new PageRequestModelImpl();
    }

    @Override
    public PageResponseModel createPageResponse() {
        return new PageResponseModelImpl();
    }

}
