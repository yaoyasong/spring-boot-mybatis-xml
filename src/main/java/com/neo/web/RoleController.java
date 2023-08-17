package com.neo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.neo.model.Role;
import com.neo.mapper.RoleMapper;

@RestController
public class RoleController {
    
    @Autowired
    private RoleMapper roleMapper;
    
    @PostMapping("/addRole")
    public void addRole(Role role) {
        roleMapper.insert(role);
    }
    
    @PutMapping("/updateRole")
    public void updateRole(Role role) {
        roleMapper.update(role);
    }
    
    @DeleteMapping("/deleteRole/{id}")
    public void deleteRole(@PathVariable("id") Integer id) {
        roleMapper.delete(id);
    }
}

