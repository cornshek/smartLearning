package org.shek.smartLearning.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.shek.smartLearning.mapper.TheoremMapper;
import org.shek.smartLearning.pojo.*;
import org.shek.smartLearning.service.LoginService;
import org.shek.smartLearning.service.MasteryService;
import org.shek.smartLearning.service.TheoremService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class TheoremServiceImpl implements TheoremService {

    @Autowired
    TheoremMapper theoremMapper;
    @Autowired
    MasteryService masteryService;
    @Autowired
    LoginService loginService;

    @Override
    public void add(Theorem theorem) {
        theoremMapper.insert(theorem);
    }

    @Override
    public List<Theorem> listRandomWithMastery(Integer number) {

        /*
         * 获取当前用户信息 Login login*/
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        Login login = loginService.findByName(username);

        /*查询所有数学定理, 存放于List<Theorem> allTheorem*/
        TheoremExample example = new TheoremExample();
        List<Theorem> allTheorem = theoremMapper.selectByExample(example);

        /*
        * 为allTheorem中的每一个Theorem设置masteryValue
        * 遍历allTheorem 根据name在mastery表中查询对应的条目，将mastery.value赋值给Theorem.masteryValue
        * 计算masteryValue的总值masterySum*/
        int masterySum = 0;
        for (Theorem theorem : allTheorem) {
            Mastery mastery = masteryService.findByKnowledge(theorem.getName(), login.getId());
            if (null == mastery) {
                /*若当前知识点没有对应的mastery条目, 将Theorem.masteryValue设置为0*/
                theorem.setMasteryValue(0);
            } else {
                theorem.setMasteryValue(mastery.getValue());
                masterySum += mastery.getValue();
            }
        }
        /*
        *在0~masterySum之间随机取整数值，加在masteryValue上
        *根据masteryValue排序allTheorem*/
        for (Theorem theorem : allTheorem) {
            /*区分masterySum的正负处理*/
            if (masterySum > 0) {
                theorem.setMasteryValue(theorem.getMasteryValue() + new Random().nextInt(masterySum));
            } else {
                theorem.setMasteryValue(theorem.getMasteryValue() - new Random().nextInt(-masterySum));
            }
        }
        Collections.sort(allTheorem);

        return allTheorem.subList(0, number);
    }

}
