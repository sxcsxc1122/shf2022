package com.atguigu.service.impl;

import com.atguigu.dao.RoleDao;
import com.atguigu.entity.Role;
import com.atguigu.service.RoleService;
import com.atguigu.util.CastUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired  //Spring框架提供的依赖注入注解   先byType再byName
    //@Resource //JDK提供的依赖注入注解   先byName再byType
    RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    // ctrl + i    ctrl + o

    @Override
    public Integer insert(Role role) {
        return roleDao.insert(role);
    }

    @Override
    public Role getById(Long id) {
        return roleDao.getById(id);
    }

    @Override
    public void update(Role role) {
        roleDao.update(role);
    }

    @Override
    public Integer delete(Long id) {
        return roleDao.delete(id);
    }

    @Override
    public PageInfo<Role> findPage(Map<String, Object> filters) {
        int pageNum = CastUtil.castInt(filters.get("pageNum"),1);
        int pageSize = CastUtil.castInt(filters.get("pageSize"),2);

        //开启分页功能，将这两个参数，与当前线程进行绑定，传递给dao层。
        // startIndex = (pageNum-1)*pageSize
        // select 语句 最后，自动增加 limit ?,?         limit startIndex,pageSIze
        PageHelper.startPage(pageNum,pageSize); // ThreadLocal

        Page<Role> page = roleDao.findPage(filters);
        return new PageInfo(page,5);
    }
}
