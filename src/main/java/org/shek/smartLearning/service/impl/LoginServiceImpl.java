package org.shek.smartLearning.service.impl;

import org.shek.smartLearning.mapper.LoginMapper;
import org.shek.smartLearning.pojo.Login;
import org.shek.smartLearning.pojo.LoginExample;
import org.shek.smartLearning.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public Login findByName(String name) {
        LoginExample example = new LoginExample();
        example.createCriteria()
                .andNameEqualTo(name);

        List<Login> loginList = loginMapper.selectByExample(example);

        //size == 0 和 null 的区别
        if (loginList.size() != 0) {
            return loginList.get(0);
        }
        return null;
    }

    @Override
    public Login findById(Integer id) {
        LoginExample example = new LoginExample();
        example.createCriteria()
                .andIdEqualTo(id);

        List<Login> loginList = loginMapper.selectByExample(example);

        //size == 0 和 null 的区别
        if (loginList.size() != 0) {
            return loginList.get(0);
        }
        return null;
    }

    @Override
    public void add(Login login) throws Exception{
        loginMapper.insert(login);
    }

    @Override
    public void delete(Integer id) {
        loginMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Login login) {
        loginMapper.updateByPrimaryKeySelective(login);
    }
}
