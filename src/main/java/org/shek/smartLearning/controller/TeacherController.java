package org.shek.smartLearning.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.shek.smartLearning.pojo.EnWord;
import org.shek.smartLearning.pojo.Theorem;
import org.shek.smartLearning.service.EnWordService;
import org.shek.smartLearning.service.StudentService;
import org.shek.smartLearning.service.TeacherService;
import org.shek.smartLearning.service.TheoremService;
import org.shek.smartLearning.util.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class TeacherController {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    EnWordService enWordService;
    @Autowired
    TheoremService theoremService;

    /*---------------------------------------知识点添加 Start*/

    /*课程列表*/
    @RequestMapping("teacher_listCourse")
    public String listCourse() {
        return "teacher/listCourse";
    }

    /*跳转到 添加知识点-数学定理 页面*/
    @RequestMapping("teacher_addTheorem")
    public String addTheoremUI() {
        return "teacher/addTheorem";
    }

    /*添加知识点-数学定理*/
    @RequestMapping(value = "teacher_addTheorem", method = RequestMethod.POST)
    public String addTheorem(Theorem theorem) {
        theoremService.add(theorem);
        return "redirect:teacher_listCourse";
    }


    /*---------------------------------------知识点添加 End*/

    /*---------------------------------------教师 Start*/



    /*教师 End*/

    /*
     * 跳转到修改密码*/
    @RequestMapping("teacher_resetPassword")
    public String resetPasswordUI() {
        return "teacher/resetPassword";
    }

    /*
     * 注销*/
    @RequestMapping("teacher_logout")
    public String logout() {
        return "redirect:logout";
    }
}
