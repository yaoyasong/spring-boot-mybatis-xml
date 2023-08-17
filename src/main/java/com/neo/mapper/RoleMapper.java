package com.neo.mapper;

import java.util.List;
import com.neo.model.Role;

public interface RoleMapper {
    void insert(Role role);
    void update(Role role);
    void delete(Integer id);
    List<Role> getAll();
}

