package com.atguigu.service;

import com.atguigu.entity.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface RoleService {  //ctrl + alt + b
    List<Role> findAll();

    Integer insert(Role role);

    Role getById(Long id);

    void update(Role role);

    Integer delete(Long id);

    PageInfo<Role> findPage(Map<String, Object> filters);
}
