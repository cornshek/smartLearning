package org.shek.smartLearning.mapper;

import java.util.List;
import org.shek.smartLearning.pojo.Student;
import org.shek.smartLearning.pojo.StudentExample;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}