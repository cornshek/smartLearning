package org.shek.smartLearning.mapper;

import java.util.List;
import org.shek.smartLearning.pojo.Test;
import org.shek.smartLearning.pojo.TestExample;

public interface TestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Test record);

    int insertSelective(Test record);

    List<Test> selectByExample(TestExample example);

    Test selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);
}