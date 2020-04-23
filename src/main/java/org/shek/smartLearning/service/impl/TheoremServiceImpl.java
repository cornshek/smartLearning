package org.shek.smartLearning.service.impl;

import org.shek.smartLearning.mapper.TheoremMapper;
import org.shek.smartLearning.pojo.EnWord;
import org.shek.smartLearning.pojo.EnWordExample;
import org.shek.smartLearning.pojo.Theorem;
import org.shek.smartLearning.pojo.TheoremExample;
import org.shek.smartLearning.service.TheoremService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TheoremServiceImpl implements TheoremService {

    @Autowired
    TheoremMapper theoremMapper;

    @Override
    public void add(Theorem theorem) {
        theoremMapper.insert(theorem);
    }

    @Override
    public List<Theorem> listRandom(Integer number) {
        TheoremExample example = new TheoremExample();
        List<Theorem> allTheorem = theoremMapper.selectByExample(example);

        List<Theorem> resultTheorem = new ArrayList<Theorem>();
        for (int i = 0; i < number; i++) {
            resultTheorem.add(allTheorem.remove(new Random().nextInt(allTheorem.size())));
        }
        return resultTheorem;
    }
}
