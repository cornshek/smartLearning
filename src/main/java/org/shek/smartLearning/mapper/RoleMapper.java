package org.shek.smartLearning.mapper;

import java.util.List;
import org.shek.smartLearning.pojo.Role;
import org.shek.smartLearning.pojo.RoleExample;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}