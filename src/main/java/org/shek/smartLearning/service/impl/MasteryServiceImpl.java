package org.shek.smartLearning.service.impl;

import org.shek.smartLearning.mapper.MasteryMapper;
import org.shek.smartLearning.pojo.Mastery;
import org.shek.smartLearning.pojo.MasteryExample;
import org.shek.smartLearning.service.MasteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MasteryServiceImpl implements MasteryService {

    @Autowired
    MasteryMapper masteryMapper;

    @Override
    public Mastery findByKnowledge(String knowledge, Integer id) {
        MasteryExample example = new MasteryExample();
        example.createCriteria()
                .andKnowledgeEqualTo(knowledge)
                .andStudentIdEqualTo(id);
        List<Mastery> masteryList = masteryMapper.selectByExample(example);

        if (0 != masteryList.size()) {
            return masteryList.get(0);
        }
        return null;
    }

    @Override
    public List<Mastery> list() {
        MasteryExample example = new MasteryExample();
        example.setOrderByClause("value desc");
        return masteryMapper.selectByExample(example);
    }

    @Override
    public void add(Mastery mastery) {
        masteryMapper.insert(mastery);
    }

    @Override
    public void update(Mastery mastery) {
        masteryMapper.updateByPrimaryKeySelective(mastery);
    }
}
