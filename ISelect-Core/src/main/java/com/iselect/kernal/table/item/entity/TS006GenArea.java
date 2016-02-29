package com.iselect.kernal.table.item.entity;

import com.iselect.kernal.table.entity.TableItemGenArea;
import java.util.List;

public interface TS006GenArea<T extends TS004Item> extends TableItemGenArea {

    public List<T> getRoles();

    public void setRoles(List<T> Roles);

    public long getRequestId();

    public void setRequestId(long RequestId);

    public long getMenuGroupId();

    public void setMenuGroupId(long groupMenuId);
}
