package com.global.spring_security_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.spring_security_demo.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {

    Role findByName(String name);

}
