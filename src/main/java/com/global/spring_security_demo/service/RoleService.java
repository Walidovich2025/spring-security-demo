package com.global.spring_security_demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.global.spring_security_demo.entity.Role;
import com.global.spring_security_demo.repository.RoleRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepo roleRepo;

    public List<Role> finaAll(){
        return roleRepo.findAll();
    }

    public Role  findById(Long id){
        return roleRepo.findById(id).orElse(null);
    }

    public Role  findByName(String name){
        return roleRepo.findByName(name);
    }

    public Role save(Role entity){
        return roleRepo.save(entity);
    }

}
