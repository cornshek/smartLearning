package org.shek.smartLearning.service;

import org.shek.smartLearning.pojo.Student;
import org.shek.smartLearning.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    /*
    * 查询所有教师信息*/
    List<Teacher> list();

    /*查询单个教师信息*/
    Teacher findById(Integer id);

    /*
     * 添加教师信息
     * @param teacher teacher对象*/
    void add(Teacher teacher) throws Exception;

    /*
     * 移除学生信息
     * @param id 教师id*/
    void delete(Integer id);

    /*
     * 更新学生信息
     * @param teacher teacher对象*/
    void update(Teacher teacher);
}
