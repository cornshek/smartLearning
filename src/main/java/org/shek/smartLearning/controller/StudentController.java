package org.shek.smartLearning.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.shek.smartLearning.pojo.EnWord;
import org.shek.smartLearning.pojo.Login;
import org.shek.smartLearning.pojo.Mastery;
import org.shek.smartLearning.pojo.Theorem;
import org.shek.smartLearning.service.*;
import org.shek.smartLearning.util.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    EnWordService enWordService;
    @Autowired
    TheoremService theoremService;
    @Autowired
    MasteryService masteryService;
    @Autowired
    LoginService loginService;

    /*测试*/
    @RequestMapping("test")
    public String test() {
        List<Theorem> theorems = theoremService.listRandomWithMastery(5);
        for (Theorem theorem : theorems) {
            System.out.println(theorem);
        }
        return "";
    }

    /*---------------------------------------知识点记忆 Start*/

    /*课程列表*/
    @RequestMapping("student_listCourse")

    public String listCourse() {
        return "student/listCourse";
    }

    /*记忆单词*/
    @RequestMapping("student_memorizeWord")
    public String memorizeWord(Model model, Integer number) throws JsonProcessingException {
        /*随机选择x(number)个单词作为题目*/
        List<EnWord> enWords = enWordService.listRandom(number);

        List<Problem> questions = new ArrayList<>();

        /*每个单词随机选择3个单词作为错误答案
        * 整理为Problem加入到List<Problem>中*/
        for (EnWord enWordCorrect : enWords) {
            List<EnWord> answersObject = enWordService.listAnswers(enWordCorrect);
            Problem problem = new Problem();

            /*正确答案的下标*/
            int i = 1;
            /*提取中文并赋值problem.answers*/
            for (EnWord enWord : answersObject) {
                problem.getAnswers().add(enWord.getTranslation());
                if (enWord.getWord().equals(enWordCorrect.getWord())) {
                    problem.setQuestion(enWordCorrect.getWord());
                    problem.setCorrectAnswer(i);
                }
                i++;
            }
            /*整理好的problem加入List<Problem> questions中*/
            questions.add(problem);
        }

        /*将List<Problem> questions 转为json字符串*/
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(questions);
//        System.out.println(jsonString);

        /*将json字符串传递到前台*/
        model.addAttribute("jsonString", jsonString);

        return "student/memorizeWord";
    }

    /*记忆定理*/
    @RequestMapping("student_memorizeTheorem")
    public String memorizeTheorem(Model model, Integer number) throws JsonProcessingException {
        /*Mastery作为权重，随机选择x(number)个单词作为题目*/
        List<Theorem> theorems = theoremService.listRandomWithMastery(number);

        List<Problem> questions = new ArrayList<>();

        for (Theorem theorem : theorems) {
            Problem problem = new Problem();
            problem.setQuestion(theorem.getName());
            List<String> answers = problem.getAnswers();
            answers.add(theorem.getContent());

            /*判断confusion是否为null或""，否则会出现空指针异常*/
            if(null != theorem.getConfusion1() && !"".equals(theorem.getConfusion1())) answers.add(theorem.getConfusion1());
            if(null != theorem.getConfusion2() && !"".equals(theorem.getConfusion2())) answers.add(theorem.getConfusion2());
            if(null != theorem.getConfusion3() && !"".equals(theorem.getConfusion3())) answers.add(theorem.getConfusion3());

            /*打乱选项*/
            Collections.shuffle(answers);

            /*标记正确答案下标*/
            for (int i = 0; i < answers.size(); i++) {
                if (answers.get(i).equals(theorem.getContent())) {
                    problem.setCorrectAnswer(i+1);
                }
            }
            questions.add(problem);
        }

        /*将List<Problem> questions 转为json字符串*/
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(questions);
//        System.out.println(jsonString);

        /*将json字符串传递到前台*/
        model.addAttribute("jsonString", jsonString);

        return "student/memorizeTheorem";
    }



    /*---------------------------------------知识点记忆 End*/

    /*---------------------------------------教师 Start*/



    /*教师 End*/

    /*
     * 跳转到修改密码*/
    @RequestMapping("student_resetPassword")
    public String resetPasswordUI() {
        return "student/resetPassword";
    }

    /*
     * 注销*/
    @RequestMapping("student_logout")
    public String logout() {
        return "redirect:logout";
    }
}
