package org.shek.smartLearning.service.impl;

import org.shek.smartLearning.mapper.EnWordsMapper;
import org.shek.smartLearning.pojo.EnWords;
import org.shek.smartLearning.pojo.EnWordsExample;
import org.shek.smartLearning.service.EnWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnWordServiceImpl implements EnWordService {
    @Autowired
    EnWordsMapper enWordsMapper;

    @Override
    public List<EnWords> list() {
        EnWordsExample example = new EnWordsExample();
        example.setOrderByClause("word desc");
        return enWordsMapper.selectByExample(example);
    }
}
