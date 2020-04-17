package org.shek.smartLearning.service;

import org.shek.smartLearning.pojo.Login;

public interface LoginService {
    /*
     * 查找登录信息
     * @param name 用户名*/
    Login findByName(String name);

    /*
     * 查找登录信息
     * @param id 登录id == 学生id*/
    Login findById(Integer id);

    /*
     * 添加登录信息
     * @param Login login 对象*/
    void add(Login login) throws Exception;

    /*
     * 移除登录信息 同时会自动移除相关的学生信息
     * @param id 登录id == 学生id*/
    void delete(Integer id);

    /*
     * 更新登录信息
     * @param login login对象*/
    void update(Login login);
}
