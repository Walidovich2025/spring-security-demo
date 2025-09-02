package com.global.spring_security_demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.spring_security_demo.entity.AppUser;

@Repository
public interface UserRepo extends JpaRepository<AppUser,Long> {

    Optional<AppUser>findByusername(String username);

}
