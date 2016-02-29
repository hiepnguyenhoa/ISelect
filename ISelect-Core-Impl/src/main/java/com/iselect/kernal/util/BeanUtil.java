/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.util;

import com.iselect.kernal.BaseDto;
import com.iselect.kernal.BaseModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author Hiep
 */
public class BeanUtil {

    public static String[] getClassShortName(String value) {
        return getSplitString(value, "\\.");
    }

    public static String[] getSplitString(String value, String delims) {
        return value.split(delims);
    }

}
