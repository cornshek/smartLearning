package org.shek.smartLearning.service.impl;

import org.shek.smartLearning.mapper.StudentMapper;
import org.shek.smartLearning.mapper.TeacherMapper;
import org.shek.smartLearning.pojo.Student;
import org.shek.smartLearning.pojo.StudentExample;
import org.shek.smartLearning.pojo.Teacher;
import org.shek.smartLearning.pojo.TeacherExample;
import org.shek.smartLearning.service.StudentService;
import org.shek.smartLearning.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<Teacher> list() {
        TeacherExample example = new TeacherExample();
        example.createCriteria();
        return teacherMapper.selectByExample(example);
    }

    @Override
    public Teacher findById(Integer id) {
        TeacherExample example = new TeacherExample();
        example.createCriteria()
                .andIdEqualTo(id);

        List<Teacher> teacherList = teacherMapper.selectByExample(example);

        if (teacherList.size() != 0) {
            return teacherList.get(0);
        }
        return null;
    }

    @Override
    public void add(Teacher teacher) throws Exception {
        teacherMapper.insert(teacher);
    }

    @Override
    public void delete(Integer id) {
        teacherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Teacher teacher) {
        teacherMapper.updateByPrimaryKeySelective(teacher);
    }
}
