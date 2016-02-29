/*
 * To change member1 license header, choose License Headers in Project Properties.
 * To change member1 template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.util;

//import com.iselect.kernal.model.MemberInfo;
import com.iselect.kernal.table.entity.Table;
import com.iselect.kernal.table.entity.TableItem;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.function.BiFunction;

/**
 *
 * @author Hiep
 */
public class LambdaUtil {

    public static final BiFunction<String, String, Boolean> compareString
            = (s1, s2) -> {
                if ((s1 == null & s2 != null) || (s1 != null & s2 == null)) {
                    return false;
                }
                if (s1 == null || s2 == null) {
                    return true;
                }
                return s1.equals(s2);
            };
    public static final BiFunction<Character, Character, Boolean> compareChar
            = (c1, c2) -> {
                if ((c1 == null & c2 != null) || (c1 != null & c2 == null)) {
                    return false;
                }
                if (c1 == null || c2 == null) {
                    return true;
                }
                return c1.equals(c2);
            };

    public static final BiFunction<Date, Date, Boolean> compareDate
            = (d1, d2) -> {
                if ((d1 == null && d2 != null) || (d1 != null && d2 == null)) {
                    return false;
                }

                if (d1 == null && d2 == null) {
                    return true;
                }
                return d1.equals(d1);
            };
    
    public static final BiFunction<Table, Table, Boolean> equalsTableHeader
            = (header1, header2) -> {
                return true;
            };

    public static final BiFunction<TableItem, TableItem, Boolean> equalsTableItem
            = (item1, item2) -> {
                if (!LambdaUtil.compareString.apply(item1.getTableKey(), item2.getTableKey())) {
                    return false;
                }
                if (!LambdaUtil.compareString.apply(item1.getItemKey(), item2.getItemKey())) {
                    return false;
                }
                if (!LambdaUtil.compareDate.apply(item1.getCreatedDate(), item2.getCreatedDate())) {
                    return false;
                }
                return true;
            };
}
