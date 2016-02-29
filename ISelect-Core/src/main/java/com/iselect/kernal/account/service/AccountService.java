/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.account.service;

import com.iselect.kernal.ISelectService;
import com.iselect.kernal.exception.EntityNotFoundException;
import com.iselect.kernal.account.dto.UserDto;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Hiep
 * @param <U>
 * @param <ID>
 */
public interface AccountService<U extends UserDto> extends ISelectService, UserDetailsService{
    
    public UserDto getUser(Long id) throws EntityNotFoundException;
    public UserDto getUser(String userName);
    
    /**
     * get all active users
     * @return list of users
     * @throws ISelectException 
     */
    public List<U> getUsers();
    
    /**
     * Insert user.
     * 1) check existing of the user by username. DuplicateEntityException could be thrown
     * 2) insert new user into database. EntityInsertException could be thrown.
     * Or Update user
     * 1) checking whether the user is existing in the system
     * 2) update the existing user.
     * @param user 
     * @throws com.iselect.kernal.exception.EntityInsertException 
     * @throws com.iselect.kernal.exception.DuplicateEntityException
     * @throws com.iselect.kernal.exception.EntityNotFoundException
     * @throws com.iselect.kernal.exception.EntityUpdateException
     * @throws com.iselect.kernal.exception.ToModelException
     */
    public void insertOrUpdateUser(U user) throws EntityNotFoundException;
    
    /**
     * Insert new user.
     * to insert a new user, the system check whether the user is existing in database to throw DuplicateEntityException if any.
     * user is considered as duplication by checking username.
     * @param user
     * @throws EntityInsertException if there is any problem with jdbc or database
     * @throws DuplicateEntityException if existing an user having same username.
     */
    public void insertUser(U user);
    
    /**
     * update user.
     * system loads the user model by id and then performing update the user model.
     * @param user
     * @throws EntityNotFoundException if the user's id doesn't exist in database
     * @throws EntityUpdateException if there is any problems else.
     */
    public void updateUser(U user) throws EntityNotFoundException;
    
    /**
     * delete user.
     * 1) check existing of the user by username. EntityNotFoundException could be thrown
     * 2) delete the user in DBMS. EntityDeleteException could be thrown
     * In the system, action deletion of an item means set the item's validFlag to -1;
     * @param user 
     * @throws com.iselect.kernal.exception.EntityNotFoundException 
     * @throws com.iselect.kernal.exception.EntityDeleteException 
     */
    public void deleteUser(U user) throws EntityNotFoundException;
    
    /**
     * delete user by Id.
     * 1) check existing of the user by username. EntityNotFoundException could be thrown
     * 2) delete the user in DBMS. EntityDeleteException could be thrown
     * In the system, action deletion of an item means set the item's validFlag to -1;
     * In the system, action deletion of an item means set the item's validFlag to -1;
     * @param id
     * @throws com.iselect.kernal.exception.EntityNotFoundException
     * @throws com.iselect.kernal.exception.EntityDeleteException
     */
    public void deleteUser(Long id) throws EntityNotFoundException;
    
    public void getUserProfile(Long id) throws EntityNotFoundException;
}
