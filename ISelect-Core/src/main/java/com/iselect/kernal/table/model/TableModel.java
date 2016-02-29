/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.table.model;

import com.iselect.kernal.table.entity.Table;
import com.iselect.kernal.BaseModel;
import com.iselect.kernal.table.item.model.TableItemModel;

/**
 *
 * @author Hiep
 * @param <T>
 */
public interface TableModel<T extends TableItemModel> extends BaseModel, Table<T>{
    
}
