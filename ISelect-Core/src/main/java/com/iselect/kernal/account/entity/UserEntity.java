/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.account.entity;

import com.iselect.kernal.BaseEntity;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Hiep
 * @param <U> extends UserProfile
 * @param <A>
 */
public interface UserEntity<U extends UserProfileEntity, A extends GrantedAuthority> extends BaseEntity, UserDetails {

    @Override
    public String getUsername();

    public void setUsername(String userName);

    @Override
    public String getPassword();

    public void setPassword(String password);

    public U getProfile();

    public void setProfile(U profile);
    
    @Override
    public Set<A> getAuthorities();
    
    public void setAuthorities(Set<A> authorities);
    
    public void addAuthority(A authority);
    
    public boolean removeAuthority(A authority);
    
}
