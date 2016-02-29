/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.table.service;

import com.iselect.kernal.ISelectService;
import com.iselect.kernal.table.dto.TableDto;
import com.iselect.kernal.table.dto.TableItemDto;
import com.iselect.kernal.table.item.dto.TS005ItemDto;
import java.util.List;

/**
 *
 * @author Hiep
 */
public interface TableService extends ISelectService{
    
    String USER_ROLE="TS004";
    String MENU_GROUP="TS005";
    String MENU_ITEM="TS006";
    
    /*table services*/
    /**
     * the function inserts new table into databse
     * @param table
     * @throws ISelectException 
     */
    public void newTable(TableDto table);
    
    /**
     * get all active table in database
     * @return
     * @throws ISelectException 
     */
    public List<? extends TableDto> getTables();
    
    /**
     * get table header by table key.
     * @param tableKey
     * @return
     * @throws ISelectException 
     */
    public TableDto getTableHeader(String tableKey);
    
    
    
    /**
     * get table item by table key and id
     * @param tableKey
     * @param id
     * @return
     * @throws ISelectException 
     */
    public TableItemDto getTableItem(String tableKey, Long id);
    
    /**
     * get  all Items by tableKey, itemKey regardless its status and validFlag
     * @param tableKey
     * @param itemKey
     * @return 
     * @throws ISelectException 
     */
    public List<TableItemDto> getTableItems(String tableKey, String itemKey);
    
    /**
     * get active and valid item
     * @param tableKey
     * @param itemKey
     * @return
     * @throws ISelectException 
     */
    public TableItemDto getTableItem(String tableKey, String itemKey);
    
    
    /*item services*/
    /**
     * get all table items of a table
     * @param tableKey
     * @return
     * @throws ISelectException 
     */
    public List<TableItemDto> getTableItems(String tableKey);

    /**
     * HiepNguyen.
     * insert new tableItem. The function have to check whether the item is existing in database.
     * Key of an item consisting of tableKey, itemKey, and validFlg.
     * @param itemDto
     * @throws ISelectException 
     */
    public void newTableItem(TableItemDto itemDto);

    public void updateTableItem(TableItemDto itemDto);

    public TableItemDto getDummyTableDto(String tableKey);
    
}
