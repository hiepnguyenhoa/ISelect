/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.table.entity;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Hiep
 * @param <T>
 */
public interface Table<T extends TableItem> extends TableElement{
    
    public void addItem(T item);
    public void addItems(List<T> items);
    public T getItem(String itemKey);
    
    public void setItems(Map<String, T> items);
    public List<T> getItems();
}
