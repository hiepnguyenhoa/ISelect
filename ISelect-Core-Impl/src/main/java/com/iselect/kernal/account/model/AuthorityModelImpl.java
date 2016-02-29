/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.account.model;

import com.iselect.kernal.account.entity.AuthorityEntityImpl;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Hiep
 */
@Entity
@Table(name = "AUTHORITY")
public class AuthorityModelImpl extends AuthorityEntityImpl implements AuthorityModel{
    
}
