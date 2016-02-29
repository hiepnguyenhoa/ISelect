/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.table.dao;

import com.iselect.kernal.ISelectDao;
import com.iselect.kernal.table.model.TableModel;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Hiep
 * @param <T>
 * @param <ID>
 */
public interface TableDao<T extends TableModel, ID extends Serializable>  extends ISelectDao<T>{
    String TABLE_KEY="tableKey";
    String GET_TABLE_HEADER_BY_TABLE_KEY="FORM %s where "+TABLE_KEY+"=:"+TABLE_KEY;
    
    public T getTable(String tableKey);
    public List<? extends T> getTables();
    public T insertTable(TableModel model);
}
