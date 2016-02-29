/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.account.entity;

import com.iselect.kernal.BaseEntityImpl;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Hiep
 * @param <U>
 * @param <A>
 */
@MappedSuperclass
public class UserEntityImpl<U extends UserProfileEntityImpl, A extends AuthorityEntityImpl>
        extends BaseEntityImpl
        implements UserEntity<U, A> {

    @Column(name = "USERNAME")
    @NotNull
    @Size(min = 6)
    protected String username;
    @Column(name = "PASSWORD")
    protected String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROFILE_ID")
    protected U profile;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name="GRANTED_AUTHORITY",
            joinColumns = {@JoinColumn(name="USER_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="AUTHORITY_ID", nullable = false, updatable = false)}
    )
    Set<A> authorities = new HashSet<>();

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public U getProfile() {
        return this.profile;
    }

    @Override
    public void setProfile(U profile) {
        this.profile = profile;
    }
    
    @Override
    public boolean isAccountNonExpired() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.validFlag;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<A> getAuthorities() {
        return this.authorities;
    }

    @Override
    public void setAuthorities(Set<A> authorities) {
        this.authorities=authorities;
    }

    @Override
    public void addAuthority(A authority) {
        this.authorities.add(authority);
    }

    @Override
    public boolean removeAuthority(A authority) {
        return this.authorities.remove(authority);                
    }
    
}
