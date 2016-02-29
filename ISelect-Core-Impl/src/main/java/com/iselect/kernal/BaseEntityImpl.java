/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hiep
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Access(AccessType.FIELD)
public abstract class BaseEntityImpl implements BaseEntity, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    protected long id = 0;
    @Column(name = "GROUP_ID")
    protected int groupId;
    @Column(name = "SERVICE_ID")
    protected byte serviceId;
    @Column(name = "VFLAG")
    protected boolean validFlag = true;
    @Column(name = "SFLAG")
    protected int statusFlag;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CRD_DATE")
    protected Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPD_DATE")
    protected Date modifiedDate;
    @Column(name = "USER_JOB")
    protected String userJob;
    @Column(name = "TRNX_ID")
    protected String transId;
    @Column(name = "TRNX_NO")
    protected int transNo;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long pId) {
        this.id = pId;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public Date getCreatedDate() {
        return this.createdDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    @Override
    public void setTransId(String transId) {
        this.transId = transId;
    }

    @Override
    public String getTransId() {
        return this.transId;
    }

    @Override
    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }

    @Override
    public String getUserJob() {
        return this.userJob;
    }

    @Override
    public void setValidFlag(boolean valid) {
        this.validFlag = valid;
    }

    @Override
    public boolean isValidFlag() {
        return this.validFlag;
    }

    @Override
    public void setStatusFlag(int status) {
        this.statusFlag = status;
    }

    @Override
    public int getStatusFlag() {
        return this.statusFlag;
    }

    @Override
    public int getGroupId() {
        return groupId;
    }

    @Override
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public byte getServiceId() {
        return serviceId;
    }

    @Override
    public void setServiceId(byte serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public int getTransNo() {
        return transNo;
    }

    @Override
    public void setTransNo(int transNo) {
        this.transNo = transNo;
    }

}
