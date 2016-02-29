/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal;

/**
 *
 * @author Hiep
 * @param <T>
 */
//@NoRepositoryBean
public interface ISelectDao<T extends BaseModel> {

     T saveOrUpdate(T model);
     void saveModel(T model);
     T updateModel(T model);    
    
}
