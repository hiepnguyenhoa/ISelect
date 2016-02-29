/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal;

/**
 *
 * @author Hiep
 */
public class ISelectDaoUtil {
    
    public static final String ENTITY_ID="id";
    public static final String GROUP_ID="groupId";
    public static final String SERVICE_ID="serviceId";
    public static final String VALID_FLAG="validFlag";
    public static final String STATUS_FLAG="statusFlag";
    public static final String CREATED_DATE="createdDate";
    public static final String MODIFIED_DATE="modifiedDate";
    public static final String TRANS_ID="transId";
    public static final String USER_JOB="userJob";
    
    public static final String SQL_SELECT_TABLE="FROM %s where 1=1 ";

    protected ISelectDaoUtil() {
    }
    
    public String condById(){
        return " and "+ENTITY_ID+"=:"+ENTITY_ID;
    }
    
    public String condByGroupId(){
        return " and "+GROUP_ID+"=:"+GROUP_ID;
    }
    
    public String condByServiceId(){
        return " and "+SERVICE_ID+"=:"+SERVICE_ID;
    }
    
    public String condByValidFlag(){
        return " and "+VALID_FLAG+"=:"+VALID_FLAG;
    }
    
    public String condByStatusFlag(){
        return " and "+STATUS_FLAG+"=:"+STATUS_FLAG;
    }
    
    public String condByCreatedDate(){
        return " and "+CREATED_DATE+"=:"+CREATED_DATE;
    }
    
    public String condByModifiedDate(){
        return " and "+MODIFIED_DATE+"=:"+MODIFIED_DATE;
    }
    
    public String condByTransId(){
        return " and "+TRANS_ID+"=:"+TRANS_ID;
    }
    
    public String condByUserJob(){
        return " and "+USER_JOB+"=:"+USER_JOB;
    }
}
