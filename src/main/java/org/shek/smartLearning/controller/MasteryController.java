package org.shek.smartLearning.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.shek.smartLearning.pojo.Login;
import org.shek.smartLearning.pojo.Mastery;
import org.shek.smartLearning.service.LoginService;
import org.shek.smartLearning.service.MasteryService;
import org.shek.smartLearning.util.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class MasteryController {

    @Autowired
    LoginService loginService;
    @Autowired
    MasteryService masteryService;

    /*计算掌握度*/
    @RequestMapping("calMastery")
    @ResponseBody
    public Map<String,String> mastery(String results, String questions, String subjectName) throws JsonProcessingException {

        /*
         * 获取当前用户信息 Login login*/
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        Login login = loginService.findByName(username);

        /*
         * 处理前端传来的results questions
         * 将 json字符串 转为 List<Problem> questions
         * 将 results 根据逗号分割后存放于 String[] subResult 中*/
        ObjectMapper objectMapper = new ObjectMapper();
        CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Problem.class);
        List<Problem> problems = objectMapper.readValue(questions, listType);

        String[] subResult = results.split(",");

        /*
         * 遍历List<Problem> problems
         * 判断表中是否有该知识点(question 表中为 knowledge)*/
        for (int i = 0; i < problems.size(); i++) {
            if (null == masteryService.findByKnowledge(problems.get(i).getKnowledge(), login.getId())) {
                /*表中无此知识点，添加*/
                Mastery mastery = new Mastery();
                mastery.setKnowledge(problems.get(i).getQuestion());
                mastery.setValue(0);
                mastery.setStudentId(login.getId());

                /*判断该题作答是否正确，对则掌握度+1 否则-1*/
                if ("true".equals(subResult[i])) {
                    mastery.setValue(mastery.getValue() + 1);
                } else {
                    mastery.setValue(mastery.getValue() - 1);
                }
                masteryService.add(mastery);
            } else {
                /*表中有此知识点，只需判断作答，调整掌握度*/
                Mastery mastery = masteryService.findByKnowledge(problems.get(i).getKnowledge(), login.getId());
                if ("true".equals(subResult[i])) {
                    mastery.setValue(mastery.getValue() + 1);
                } else {
                    mastery.setValue(mastery.getValue() - 1);
                }
                masteryService.update(mastery);
            }
        }

        Map<String,String> map = new HashMap<String, String>();
        map.put("result", "已更新知识点掌握度");
        return map;
    }


}
