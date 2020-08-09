package com.lijiaqing.studentmanage.controller;


import com.lijiaqing.studentmanage.entity.LoginUser;
import com.lijiaqing.studentmanage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String Login(@RequestParam("userid") String userid,
                        @RequestParam("password") String password,
                        @RequestParam("role") String role,
                        Map<String, Object> map, HttpSession session) {
        LoginUser LU = loginService.Select(userid, password);
        //判断登录类型
        if (LU.getUserid()!=null) {
            session.setAttribute("loginUser", LU.getRealname());
            session.setAttribute("loginuserid", LU.getUserid());
            if (LU.getRole().equals(role)&&role.equals("学生")) {
                return "redirect:StuMainPage.html";
            }
            if (LU.getRole().equals(role)&&role.equals("教师")) {
                return "redirect:TeaMainPage.html";
            }
            if (LU.getRole().equals(role)&&role.equals("管理员")) {
                return "redirect:ManMainPage.html";
            }
        } else {
            map.put("msg", "用户名密码错误");//登录失败错误提示
            return "login";
        }
        return null;
    }
}
