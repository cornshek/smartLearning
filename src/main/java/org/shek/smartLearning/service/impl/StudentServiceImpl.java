package org.shek.smartLearning.service.impl;

import org.shek.smartLearning.mapper.StudentMapper;
import org.shek.smartLearning.pojo.Student;
import org.shek.smartLearning.pojo.StudentExample;
import org.shek.smartLearning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> list() {
        StudentExample example = new StudentExample();
        return studentMapper.selectByExample(example);
    }

    @Override
    public List<Student> findByName(String name) {
        StudentExample example = new StudentExample();
        example.createCriteria()
                .andNameLike("%" + name + "%");
        return studentMapper.selectByExample(example);
    }

    @Override
    public Student findById(Integer id) {
        StudentExample example = new StudentExample();
        example.createCriteria()
                .andIdEqualTo(id);

        List<Student> studentList = studentMapper.selectByExample(example);

        if (studentList.size() != 0) {
            return studentList.get(0);
        }
        return null;
    }

    @Override
    public void add(Student student) throws Exception {
        studentMapper.insert(student);
    }

    @Override
    public void delete(Integer id) {
        studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Student student) {
        studentMapper.updateByPrimaryKeySelective(student);
    }
}
