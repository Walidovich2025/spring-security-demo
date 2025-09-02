package com.global.spring_security_demo.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.global.spring_security_demo.entity.AppUser;
import com.global.spring_security_demo.entity.Role;
import com.global.spring_security_demo.service.RoleService;
import com.global.spring_security_demo.service.UserService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StartUpApp implements CommandLineRunner {

    private final RoleService roleService;
    private final UserService userService;

    

    @Override
    public void run(String... args) throws Exception {

        if(roleService.finaAll().isEmpty()){
            roleService.save(new Role(null,"admin"));
            roleService.save(new Role(null,"user"));
            roleService.save(new Role(null,"employee"));
        }

        if(userService.finaAll().isEmpty()){

            Set<Role>adminRoles=new HashSet<>();
            adminRoles.add(roleService.findByName("admin"));
            
            Set<Role>userRoles=new HashSet<>();
            userRoles.add(roleService.findByName("user"));

            Set<Role>employeeRoles=new HashSet<>();
            employeeRoles.add(roleService.findByName("employee"));


            userService.save(new AppUser(null,"Amin shawky","amin","1123",adminRoles));
            userService.save(new AppUser(null,"nour chain","nour0","456",userRoles));
            userService.save(new AppUser(null,"mohand yasser","mohand","789",employeeRoles));
        }




        
    }

}
