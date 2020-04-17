package org.shek.smartLearning.controller;

import org.shek.smartLearning.exception.CustomException;
import org.shek.smartLearning.pojo.Login;
import org.shek.smartLearning.pojo.Student;
import org.shek.smartLearning.service.LoginService;
import org.shek.smartLearning.service.StudentService;
import org.shek.smartLearning.util.SHA1Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.CustomSQLExceptionTranslatorRegistrar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.InputStream;

@Controller
@RequestMapping("")
public class AdminController {
    @Autowired
    StudentService studentService;
    @Autowired
    LoginService loginService;

    /*学生 Start*/

    /*
     * 显示所有学生*/
    @RequestMapping("admin_listStudent")
    public String listStudent(Model model) {
        model.addAttribute("studentList", studentService.list());
        return "admin/listStudent";
    }

    /*
     * 显示一个学生*/
    @RequestMapping("admin_selectStudent")
    public String selectStudent() {
        return "";
    }

    /*
     * 跳转添加学生页面*/
    @RequestMapping(value = "admin_addStudent", method = RequestMethod.GET)
    public String addStudentUI() {
        return "admin/addStudent";
    }

    /*
     * 添加学生信息*/
    @RequestMapping(value = "admin_addStudent", method = RequestMethod.POST)
    public String addStudent(Student student) throws Exception {
        Login login = loginService.findByName(student.getName());
        if (login != null) {
            throw new CustomException("该名称已被注册，无法添加");
        } else {
            //添加登录信息
            login = new Login();
            login.setName(student.getName());
            //默认密码为123
            login.setPassword(SHA1Utils.entryptPassword("123"));
            //student roleId为3
            login.setRoleId(3);
            loginService.add(login);

            //添加学生信息
            student.setId(login.getId());
            studentService.add(student);
        }
        return "redirect:admin_listStudent";
    }

    /*
     * 移除学生*/
    @RequestMapping("admin_deleteStudent")
    public String deleteStudent(Integer id) {

        //移除对应的登录信息，同时自动移除学生信息
        loginService.delete(id);
        return "redirect:admin_listStudent";
    }

    /*
     * 跳转到编辑学生信息*/
    @RequestMapping(value = "admin_editStudent", method = RequestMethod.GET)
    public String editStudentUI(Integer id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute(student);

        return "admin/editStudent";
    }

    /*
     * 更新编辑学生信息*/
    @RequestMapping(value = "admin_editStudent", method = RequestMethod.POST)
    public String editStudent(Student student) {
        Login login = loginService.findById(student.getId());
        login.setName(student.getName());
        loginService.update(login);

        studentService.update(student);

        return "redirect:admin_listStudent";
    }

    /*学生 End*/
}
