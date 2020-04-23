package org.shek.smartLearning.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.shek.smartLearning.mapper.EnWordMapper;
import org.shek.smartLearning.pojo.EnWord;
import org.shek.smartLearning.pojo.EnWordExample;
import org.shek.smartLearning.service.EnWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EnWordServiceImpl implements EnWordService {
    @Autowired
    EnWordMapper enWordMapper;

    @Override
    public List<EnWord> listRandom(Integer number) {
        EnWordExample example = new EnWordExample();
        List<EnWord> allWords = enWordMapper.selectByExample(example);

        List<EnWord> resultWords = new ArrayList<EnWord>();
        for (int i = 0; i < number; i++) {
            resultWords.add(allWords.remove(new Random().nextInt(allWords.size())));
        }
        return resultWords;
    }

    @Override
    public List<EnWord> listAnswers(EnWord answer) {
        EnWordExample example = new EnWordExample();
        List<EnWord> allWords = enWordMapper.selectByExample(example);

        List<EnWord> resultWords = new ArrayList<EnWord>();

        /*将正确答案加入resultWords*/
        resultWords.add(answer);

        /*移除正确答案*/
        for (int i = allWords.size()-1; i >= 0; i--) {
            if (allWords.get(i).getWord().equals(answer.getWord())) {
                allWords.remove(i);
            }
        }

        /*随机选择3个错误答案加入resultWords*/
        for (int i = 0; i < 3; i++) {
            resultWords.add(allWords.remove(new Random().nextInt(allWords.size())));
        }

        /*打乱答案的顺序*/
        Collections.shuffle(resultWords);
        return resultWords;
    }


}
