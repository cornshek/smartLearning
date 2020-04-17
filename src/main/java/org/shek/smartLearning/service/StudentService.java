package org.shek.smartLearning.service;

import org.shek.smartLearning.pojo.Student;

import java.util.List;

public interface StudentService {
    /*
    * 查询所有学生信息*/
    List<Student> list();

    /*查询单个学生信息*/
    Student findById(Integer id);

    /*
     * 添加学生信息
     * @param student student对象*/
    void add(Student student) throws Exception;

    /*
     * 移除学生信息
     * @param id 学生id*/
    void delete(Integer id);

    /*
     * 更新学生信息
     * @param student student对象*/
    void update(Student student);
}
