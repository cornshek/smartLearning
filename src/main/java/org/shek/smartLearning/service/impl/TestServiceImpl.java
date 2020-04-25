package org.shek.smartLearning.service.impl;

import org.shek.smartLearning.mapper.TestMapper;
import org.shek.smartLearning.pojo.Test;
import org.shek.smartLearning.pojo.TestExample;
import org.shek.smartLearning.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;

    @Override
    public void add(Test test) {
        testMapper.insert(test);
    }

    @Override
    public List<Test> list() {
        TestExample example = new TestExample();
        return testMapper.selectByExample(example);
    }
}
