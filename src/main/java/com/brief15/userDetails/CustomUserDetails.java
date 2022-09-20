package com.brief15.userDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.soussHOApp.entities.Permission;
import com.soussHOApp.entities.Users;

public class CustomUserDetails implements UserDetails {

    private Users users;
    

    public CustomUserDetails(Users users) {
        super();
        this.users = users;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Permission> roles = users.getPermissions();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Permission role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
         
        return authorities;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return users.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }


}
