package org.shek.smartLearning.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.shek.smartLearning.mapper.RecordMapper;
import org.shek.smartLearning.pojo.Login;
import org.shek.smartLearning.pojo.Record;
import org.shek.smartLearning.pojo.RecordExample;
import org.shek.smartLearning.service.LoginService;
import org.shek.smartLearning.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    LoginService loginService;
    @Autowired
    RecordMapper recordMapper;

    @Override
    public Record check(Integer id) {
        /*
         * 获取当前用户信息 Login login*/
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        Login login = loginService.findByName(username);

        RecordExample example = new RecordExample();
        example.createCriteria()
                .andStudentIdEqualTo(login.getId())
                .andTestIdEqualTo(id);

        if (0 != recordMapper.selectByExample(example).size()) {
            return recordMapper.selectByExample(example).get(0);
        }
        return null;
    }

    @Override
    public void add(Record record) {
        recordMapper.insert(record);
    }
}
