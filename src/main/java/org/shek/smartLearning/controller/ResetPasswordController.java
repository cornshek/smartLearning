package org.shek.smartLearning.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.shek.smartLearning.exception.CustomException;
import org.shek.smartLearning.pojo.Login;
import org.shek.smartLearning.service.LoginService;
import org.shek.smartLearning.util.SHA1Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ResetPasswordController {

    @Autowired
    LoginService loginService;

    /*
     * 修改当前用户密码
     * @param oldPassword 旧密码
     * @param password1  新密码 password1 == password2*/
    @RequestMapping("resetPassword")
    public String resetPassword(String oldPassword, String password1) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        Login login = loginService.findByName(username);

        if (!SHA1Utils.validatePassword(oldPassword, login.getPassword())) {
            throw new CustomException("旧密码错误");
        } else {
            login.setPassword(SHA1Utils.entryptPassword(password1));
            loginService.update(login);
        }
        return "redirect:logout";
    }
}
