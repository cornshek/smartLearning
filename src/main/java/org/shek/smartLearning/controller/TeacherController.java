package org.shek.smartLearning.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.shek.smartLearning.pojo.*;
import org.shek.smartLearning.service.*;
import org.shek.smartLearning.util.Page;
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
    @Autowired
    PoetryService poetryService;
    @Autowired
    TestService testService;
    @Autowired
    MasteryService masteryService;

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

    @RequestMapping("teacher_addPoetry")
    public String addPoetryUI() {
        return "teacher/addPoetry";
    }

    /*添加知识点-古诗*/
    @RequestMapping(value = "teacher_addPoetry", method = RequestMethod.POST)
    public String addPoetry(Poetry poetry) {
        poetryService.add(poetry);
        return "redirect:teacher_listCourse";
    }


    /*---------------------------------------知识点添加 End*/



    /*---------------------------------------查看知识点 Start*/

    /*查看知识点-英文单词*/
    @RequestMapping("teacher_listWord")
    public String listWord(Model model, Page page) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<EnWord> enWords = enWordService.list();
        int total = (int) new PageInfo<>(enWords).getTotal();
        page.setTotal(total);

        model.addAttribute("enWords", enWords);
        model.addAttribute("page", page);
        return "teacher/listWord";
    }

    /*搜索知识点-英文单词*/
    @RequestMapping("teacher_selectWord")
    public String selectWord(Model model, String word) {
        List<EnWord> enWords = enWordService.findByWord(word);
        model.addAttribute("enWords", enWords);

        return "teacher/listWordSelect";
    }

    /*查看知识点-数学定理*/
    @RequestMapping("teacher_listTheorem")
    public String listTheorem(Model model, Page page) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Theorem> theorems = theoremService.list();
        int total = (int) new PageInfo<>(theorems).getTotal();

        model.addAttribute("theorems", theorems);
        model.addAttribute("page", page);

        return "teacher/listTheorem";
    }

    /*搜索知识点-数学定理*/
    @RequestMapping("teacher_selectTheorem")
    public String selectTheorem(Model model, String name) {
        List<Theorem> theorems = theoremService.findByName(name);
        model.addAttribute("theorems", theorems);

        return "teacher/listTheoremSelect";
    }

    /*查看知识点-古诗*/
    @RequestMapping("teacher_listPoetry")
    public String listPoetry(Model model, Page page) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Poetry> poetryList = poetryService.list();
        int total = (int) new PageInfo<>(poetryList).getTotal();
        page.setTotal(total);

        model.addAttribute("poetryList", poetryList);
        model.addAttribute("page", page);

        return "teacher/listPoetry";
    }

    /*搜索知识点-古诗*/
    @RequestMapping("teacher_selectPoetry")
    public String selectPoetry(Model model, String blank) {
        List<Poetry> poetryList = poetryService.findByBlank(blank);
        model.addAttribute("poetryList", poetryList);

        return "teacher/listPoetrySelect";
    }

    /*查看知识点 End*/


    /*---------------------------------------添加习题 Start*/

    @RequestMapping("teacher_addTest")
    public String addTestUI(Model model, String knowledge) {
        model.addAttribute("knowledge", knowledge);
        return "teacher/addTest";
    }

    @RequestMapping(value = "teacher_addTest", method = RequestMethod.POST)
    public String addTest(Test test) {
        testService.add(test);
        return "redirect:teacher_listCourse";
    }
    /*添加习题 End*/


    /*---------------------------------------查看学生 Start*/

    /*学生列表*/
    @RequestMapping("teacher_listStudent")
    public String listStudent(Model model) {
        List<Student> studentList = studentService.list();
        model.addAttribute("studentList", studentList);
        return "teacher/listStudent";
    }

    /*学生列表-搜索*/
    @RequestMapping("teacher_selectStudent")
    public String selectStudent(Model model, String name) {
        List<Student> studentList = studentService.findByName(name);
        model.addAttribute("studentList", studentList);
        return "teacher/listStudent";
    }

    /*查看掌握程度*/
    @RequestMapping("teacher_listMastery")
    public String listMastery(Model model, Page page) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Mastery> masteryList = masteryService.list();
        int total = (int) new PageInfo<>(masteryList).getTotal();
        page.setTotal(total);

        model.addAttribute("masteryList", masteryList);
        model.addAttribute("page", page);

        return "teacher/listMastery";
    }

    /*查看学生 End*/

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
