package org.shek.smartLearning.mapper;

import java.util.List;
import org.shek.smartLearning.pojo.Teacher;
import org.shek.smartLearning.pojo.TeacherExample;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByExample(TeacherExample example);

    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}