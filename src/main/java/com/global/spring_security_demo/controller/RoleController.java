package com.global.spring_security_demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.spring_security_demo.service.RoleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/role")

@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;
    @GetMapping("")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(roleService.finaAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(roleService.findById( id));
    }



}