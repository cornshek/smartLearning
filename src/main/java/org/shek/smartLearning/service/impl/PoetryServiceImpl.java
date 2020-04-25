package org.shek.smartLearning.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.shek.smartLearning.mapper.PoetryMapper;
import org.shek.smartLearning.pojo.*;
import org.shek.smartLearning.service.LoginService;
import org.shek.smartLearning.service.MasteryService;
import org.shek.smartLearning.service.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class PoetryServiceImpl implements PoetryService {

    @Autowired
    LoginService loginService;
    @Autowired
    PoetryMapper poetryMapper;
    @Autowired
    MasteryService masteryService;

    @Override
    public void add(Poetry poetry) {
        poetryMapper.insert(poetry);
    }

    @Override
    public List<Poetry> list() {
        PoetryExample example = new PoetryExample();
        return poetryMapper.selectByExample(example);
    }

    @Override
    public List<Poetry> findByBlank(String blank) {
        PoetryExample example = new PoetryExample();
        example.createCriteria()
                .andBlankLike("%" + blank + "%");
        return poetryMapper.selectByExample(example);
    }

    @Override
    public List<Poetry> listRandomWithMastery(Integer number) {
        /*
         * 获取当前用户信息 Login login*/
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        Login login = loginService.findByName(username);

        /*查询所有古诗, 存放于List<Poetry> allPoetry*/
        PoetryExample example = new PoetryExample();
        List<Poetry> allPoetry = poetryMapper.selectByExample(example);

        /*
         * 为allPoetry中的每一个Poetry设置masteryValue
         * 遍历allPoetry 根据blank在mastery表中查询对应的条目，将mastery.value赋值给Poetry.masteryValue
         * 计算masteryValue的总值masterySum*/
        int masterySum = 0;
        for (Poetry poetry : allPoetry) {
            Mastery mastery = masteryService.findByKnowledge(poetry.getBlank(), login.getId());
            if (null == mastery) {
                /*若当前知识点没有对应的mastery条目, 将Poetry.masteryValue设置为0*/
                poetry.setMasteryValue(0);
            } else {
                poetry.setMasteryValue(mastery.getValue());
                masterySum += mastery.getValue();
            }
        }
        /*
         *在0~masterySum之间随机取整数值，加在masteryValue上
         *根据masteryValue排序allPoetry*/
        for (Poetry poetry : allPoetry) {
            /*区分masterySum的正负处理，为0时不处理*/
            if (masterySum > 0) {
                poetry.setMasteryValue(poetry.getMasteryValue() + new Random().nextInt(masterySum));
            } else if (masterySum < 0){
                poetry.setMasteryValue(poetry.getMasteryValue() - new Random().nextInt(-masterySum));
            }
        }
        Collections.sort(allPoetry);

        if (allPoetry.size() >= number) {
            return allPoetry.subList(0, number);
        }
        return allPoetry;
    }
}
