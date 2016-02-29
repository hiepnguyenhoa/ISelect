/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal;

import java.io.Serializable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 *
 * @author Hiep
 */
@NoRepositoryBean
public interface ISelectCrudDao<T> extends Repository<T, Long> {

    long count();

    void delete(Long id);

    void delete(Iterable<? extends T> entities);

    void delete(T entity);

    void deleteAll();

    boolean exists(Long id);

    Iterable<T> findAll();

    T findOne(Long id);

    Iterable<T> save(Iterable<? extends T> entities);

    T save(T entity);
    
    Iterable<T> update(Iterable<? extends T> entities);

    T update(T entity);

}
