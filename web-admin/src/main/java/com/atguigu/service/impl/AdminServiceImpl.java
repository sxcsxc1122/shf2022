package com.atguigu.service.impl;

import com.atguigu.base.BaseDao;
import com.atguigu.base.BaseServiceImpl;
import com.atguigu.dao.AdminDao;
import com.atguigu.entity.Admin;
import com.atguigu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {

    @Resource
    AdminDao adminDao;

    @Override
    public BaseDao<Admin> getEntityDao() {
        return adminDao;
    }
}
