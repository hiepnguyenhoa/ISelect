/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.table.dao;

import com.iselect.kernal.ISelectDao;
import com.iselect.kernal.table.item.model.TableItemModel;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Hiep
 * @param <T>
 * @param <ID>
 */
public interface TableItemDao<T extends TableItemModel, ID extends Serializable> extends ISelectDao<T> {

    /**
     * get table item by item's id
     * @param pItemModel
     * @param id
     * @return
     * @throws EntityGetException 
     */
    public T getItem(T pItemModel, boolean id);

    /**
     * get all active and valid flag items by tableKey, itemKey, GroupId, ServiceId, validFrom, validTo 
     * @param pItemModel
     * @return 
     * @throws com.iselect.kernal.exception.EntityGetException
     * @throws com.iselect.kernal.exception.DuplicateEntityException
     */
    public T getItem(T pItemModel);
    
    /**
     * get all active and valid flag items by tableKey
     *
     * @param pItemModel
     * @return
     * @throws com.iselect.kernal.exception.EntityGetException
     */
    public List<T> getItemsByTable(T pItemModel);
    
    /**
     * get active items by tableKey and itemKey
     * @param pItemModel
     * @param itemKey
     * @return
     * @throws EntityGetException 
     */
    public List<T> getItemsByTable(T pItemModel, boolean itemKey);
    
    public List<T> getItemsByTable(T pItemModel, boolean itemKey, boolean validFlag, boolean statusFlag);
    
    /**
     * get all items by tableKey,  valid and status flag
     *
     * @param pItemModel
     * @param statusFlag
     * @param validFlag
     * @return
     * @throws com.iselect.kernal.exception.EntityGetException
     */
    public List<T> getItemsByTable(T pItemModel, boolean validFlag, boolean statusFlag);

    /**
     * get a list of table items by conditions
     *
     * @param pItemModel on to filter
     * @param id
     * @param tableKey on to filter
     * @param itemKey on to filter
     * @param groupId on to filter
     * @param serviceId on to filter
     * @param validFlag on to filter
     * @param statusFlag on to filter
     * @return
     */
    public List<T> getItemsByTable(T pItemModel, boolean itemKey,
            boolean groupId, boolean serviceId, 
            boolean validFlag, boolean statusFlag);
    
    public List<T> getItemsByTable(T pItemModel, boolean itemKey,
            boolean groupId, boolean serviceId, 
            boolean validFrom, boolean validTo,
            boolean validFlag, boolean statusFlag);

    /**
     * This method inserts the new item into database. To insert the method
     * checks whether the model item is existing in database. Key to check
     * duplication consists of tableKey, itemKey, and validFlg fields
     *
     * @param model
     * @throws EntityInsertException
     * @throws com.iselect.kernal.exception.DuplicateEntityException
     */
    public void insertItem(T model);

    public void updateItem(TableItemModel itemModel);
}
