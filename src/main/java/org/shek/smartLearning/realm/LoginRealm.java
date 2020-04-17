package org.shek.smartLearning.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.shek.smartLearning.pojo.Login;
import org.shek.smartLearning.pojo.Role;
import org.shek.smartLearning.service.LoginService;
import org.shek.smartLearning.service.RoleService;
import org.shek.smartLearning.util.SHA1Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class LoginRealm extends AuthorizingRealm {

    @Autowired
    LoginService loginService;
    @Autowired
    RoleService roleService;

    /*
    * 获取身份信息，从数据库获取用户的角色信息
    * 权限验证时自动调用*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String name = (String) getAvailablePrincipal(principalCollection);

        Role role = null;

        //获取角色对象
        try {
            Login login = loginService.findByName(name);
            role = roleService.findById(login.getRoleId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //通过用户名从数据库获取角色信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> r = new HashSet<>();
        if (role != null) {
            r.add(role.getName());
            info.setRoles(r);
        }
        return info;
    }

    /*
    * 进行身份验证，登录时自动调用*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //用户名
        String userName = (String) authenticationToken.getPrincipal();
        //密码
        String password = new String((char[]) authenticationToken.getCredentials());

        Login login = null;
        try {
            login = loginService.findByName(userName);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (login == null) {
            //无用户名时
            throw new UnknownAccountException("该用户不存在");
        } else if (!SHA1Utils.validatePassword(password, login.getPassword())) {
            //密码错误
            throw new IncorrectCredentialsException("密码错误");
        }

        //身份验证通过，返回身份信息
        return new SimpleAuthenticationInfo(userName, password, getName());
    }
}
