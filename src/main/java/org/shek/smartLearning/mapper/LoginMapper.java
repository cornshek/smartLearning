package org.shek.smartLearning.mapper;

import java.util.List;
import org.shek.smartLearning.pojo.Login;
import org.shek.smartLearning.pojo.LoginExample;

public interface LoginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Login record);

    int insertSelective(Login record);

    List<Login> selectByExample(LoginExample example);

    Login selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);
}