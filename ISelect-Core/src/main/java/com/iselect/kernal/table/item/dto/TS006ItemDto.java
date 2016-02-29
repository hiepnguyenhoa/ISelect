package com.iselect.kernal.table.item.dto;
import com.iselect.kernal.table.dto.TableItemDto;
import com.iselect.kernal.table.item.entity.TS006Item;

public interface TS006ItemDto<T extends TS004ItemDto> extends TableItemDto, TS006Item<T>{
}