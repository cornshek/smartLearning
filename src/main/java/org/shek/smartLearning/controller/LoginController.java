package org.shek.smartLearning.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.shek.smartLearning.pojo.Login;
import org.shek.smartLearning.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    /*
     * 登录表单处理
     * @param Login  Login对象*/
    @RequestMapping(value = "/login")
    public String login(Model model, Login login, RedirectAttributes redirectAttributes) {

        //shiro实现登录
        UsernamePasswordToken token = new UsernamePasswordToken(login.getName(),login.getPassword());
        Subject subject = SecurityUtils.getSubject();

        //如果获取不到用户名则登录失败，抛出异常
        subject.login(token);

        if(subject.hasRole("admin")) {
            return "redirect:admin_listStudent";
        }
        return "";
    }
}
