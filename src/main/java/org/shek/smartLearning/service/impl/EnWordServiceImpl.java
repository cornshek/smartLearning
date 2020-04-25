package org.shek.smartLearning.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.shek.smartLearning.mapper.EnWordMapper;
import org.shek.smartLearning.pojo.*;
import org.shek.smartLearning.service.EnWordService;
import org.shek.smartLearning.service.LoginService;
import org.shek.smartLearning.service.MasteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EnWordServiceImpl implements EnWordService {
    @Autowired
    EnWordMapper enWordMapper;
    @Autowired
    LoginService loginService;
    @Autowired
    MasteryService masteryService;

    @Override
    public List<EnWord> listRandomWithMastery(Integer number) {
        /*
         * 获取当前用户信息 Login login*/
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        Login login = loginService.findByName(username);

        /*查询所有英文单词, 存放于List<EnWord> allWords*/
        EnWordExample example = new EnWordExample();
        List<EnWord> allWords = enWordMapper.selectByExample(example);

        /*
         * 为allWords中的每一个EnWord设置masteryValue
         * 遍历allWords 根据word在mastery表中查询对应的条目，将mastery.value赋值给word.masteryValue
         * 计算masteryValue的总值masterySum*/
        int masterySum = 0;
        for (EnWord enWord : allWords) {
            Mastery mastery = masteryService.findByKnowledge(enWord.getWord(), login.getId());
            if (null == mastery) {
                /*若当前知识点没有对应的mastery条目, 将Theorem.masteryValue设置为0*/
                enWord.setMasteryValue(0);
            } else {
                enWord.setMasteryValue(mastery.getValue());
                masterySum += mastery.getValue();
            }
        }

        /*
         *在0~masterySum之间随机取整数值，加在masteryValue上
         *根据masteryValue排序allWords*/
        for (EnWord enWord : allWords) {
            /*区分masterySum的正负处理，为0时不处理*/
            if (masterySum > 0) {
                enWord.setMasteryValue(enWord.getMasteryValue() + new Random().nextInt(masterySum));
            } else if (masterySum < 0){
                enWord.setMasteryValue(enWord.getMasteryValue() - new Random().nextInt(-masterySum));
            }
        }
        Collections.sort(allWords);

        if (allWords.size() >= number) {
            return allWords.subList(0, number);
        }
        return allWords;
    }

    @Override
    public List<EnWord> list() {
        EnWordExample example = new EnWordExample();
        return enWordMapper.selectByExample(example);
    }

    @Override
    public List<EnWord> findByWord(String word) {
        EnWordExample example = new EnWordExample();
        example.createCriteria()
                .andWordLike(word + "%");
        return enWordMapper.selectByExample(example);
    }

    @Override
    public List<EnWord> listAnswers(EnWord answer) {
        EnWordExample example = new EnWordExample();
        List<EnWord> allWords = enWordMapper.selectByExample(example);

        List<EnWord> resultWords = new ArrayList<>();

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
