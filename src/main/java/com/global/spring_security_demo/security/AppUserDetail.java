package com.global.spring_security_demo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.global.spring_security_demo.entity.AppUser;

public class AppUserDetail implements UserDetails{

    private Long id;
    private String fullName;
    private String username;
    private String password;
    private List<GrantedAuthority>authorities;
     
    public AppUserDetail(){
        super();
    }
    public AppUserDetail(AppUser user) {
        super();
        this.id = user.getId();
        this.fullName = user.getFullName();
        this.username = user.getUsername();
        this.password = user.getPassword();
        List<GrantedAuthority>authorities=new ArrayList<>();
        if(!user.getRoles().isEmpty()){
            user.getRoles().forEach(role->{
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
           
        }
        

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public @Nullable String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

}
