/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.account.service;

import com.iselect.kernal.ISelectServiceAbst;
import com.iselect.kernal.exception.EntityNotFoundException;
import com.iselect.kernal.account.dao.UserDaoExt;
import com.iselect.kernal.account.dto.AuthorityDto;
import com.iselect.kernal.account.dto.UserDto;
import com.iselect.kernal.account.dto.UserDtoImpl;
import com.iselect.kernal.account.dto.UserProfileDto;
import com.iselect.kernal.account.model.AuthorityModel;
import com.iselect.kernal.account.model.UserModel;
import com.iselect.kernal.account.model.UserProfileModel;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hiep
 */
@Service
@Transactional
public class AccountServiceImpl extends ISelectServiceAbst implements AccountService<UserDto> {

    @Autowired
    private UserDaoExt userDaoExt;

    @Override
    @Transactional(readOnly = true)
    public UserDto getUser(Long id) throws
            EntityNotFoundException {
//        UserModel userModel = (UserModel)this.userDaoExt.findOne(id);
//        UserDto userDto = new UserDtoImpl();
//        BeanUtils.copyProperties(userModel, userDto);
//        
//        return userDto;
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUser(String userName) {
        UserModel userModel = this.userDaoExt.getByUserName(userName);
        UserDto userDto = new UserDtoImpl();
        BeanUtils.copyProperties(userModel, userDto);

        return userDto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getUsers() {
//        Iterable<UserModel> userModels = this.userDaoExt.findAll();
//        List<UserDto> userDtos = new ArrayList<>();
//        for (UserModel userModel : userModels) {
//            UserDto userDto = new UserDtoImpl();
//            BeanUtils.copyProperties(userModel, userDto);
//            userDtos.add(userDto);
//        }
//        return userDtos;
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteUser(Long id) throws EntityNotFoundException {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public void getUserProfile(Long id) throws EntityNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertOrUpdateUser(UserDto user) throws EntityNotFoundException {
        if(user.getId()==0)
            insertUser(user);
        else
            updateUser(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void insertUser(UserDto user) {
        UserModel userModel = modelFactory.createUser();
        BeanUtils.copyProperties(user, userModel);
        userDaoExt.save(userModel);
        BeanUtils.copyProperties(userModel, user);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateUser(UserDto user) throws EntityNotFoundException {
//        UserModel userModel = new UserModelImpl();
//        BeanUtils.copyProperties(user, userModel);
//        userModel = (UserModel) userDaoExt.update(userModel);
    }

    @Override
    public void deleteUser(UserDto user) throws EntityNotFoundException {
//        UserModel userModel = new UserModelImpl();
//        BeanUtils.copyProperties(user, userModel);
//        userDaoExt.delete(userModel);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto loadUserByUsername(String string) throws UsernameNotFoundException {
        UserModel<UserProfileModel, AuthorityModel> userModel = this.userDaoExt.getByUserName(string);
        if (userModel == null) {
            return null;
        }

        UserDto userDto = dtoFactory.createUser();
        BeanUtils.copyProperties(userModel, userDto);

        UserProfileModel profileModel = userModel.getProfile();
        if (profileModel != null) {
            UserProfileDto profileDto = dtoFactory.createUserProfile();
            BeanUtils.copyProperties(profileModel, profileDto);
        }
        
        Collection<AuthorityModel> authorities = userModel.getAuthorities();
        for (AuthorityModel auth : authorities) {
            AuthorityDto authorityDto = dtoFactory.createAuthority();
            BeanUtils.copyProperties(auth, authorityDto);
            userDto.addAuthority(authorityDto);
        }

        return userDto;
    }
}
