package org.shek.smartLearning.service.impl;

import org.shek.smartLearning.mapper.RoleMapper;
import org.shek.smartLearning.pojo.Role;
import org.shek.smartLearning.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public Role findById(int id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
