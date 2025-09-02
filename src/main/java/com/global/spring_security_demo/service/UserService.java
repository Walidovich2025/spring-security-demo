package com.global.spring_security_demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.global.spring_security_demo.entity.AppUser;
import com.global.spring_security_demo.repository.UserRepo;
import com.global.spring_security_demo.security.AppUserDetail;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public List<AppUser> finaAll(){
        return userRepo.findAll();
    }

    public AppUser  findById(Long id){
        return userRepo.findById(id).orElse(null);
    }

    public Optional<AppUser>findByusername(String username){
        return userRepo.findByusername(username);
    }



    public AppUser save(AppUser entity){

        entity.setPassword(passwordEncoder.encode(entity.getPassword()));//encode password before store in database
        return userRepo.save(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser>appuser= userRepo.findByusername(username);
        if(!appuser.isPresent()){
            throw new UsernameNotFoundException("this username not found with the selected user nmae "+username); 
        }
        //  User is a class by spring implement user details and here we will not depend on in memory storage 
        // depend on StartUpApp inputts
         return new AppUserDetail(appuser.get());

        
    }

    // private static List<GrantedAuthority>getAuthorities(AppUser user){//map roles to granded authorities
    //     List<GrantedAuthority>authorities=new ArrayList<>();

    //     if(!user.getRoles().isEmpty()){
    //         user.getRoles().forEach(role->{
    //             authorities.add(new SimpleGrantedAuthority(role.getName()));
    //         });
    //     }

    //     return authorities;
    // }


}
