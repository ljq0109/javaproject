package com.lijiaqing.studentmanage.controller;

import com.lijiaqing.studentmanage.entity.LoginUser;
import com.lijiaqing.studentmanage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/*
 *显示首页信息
 */

@Controller
public class PublicController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/info")
    public String info() {
        return "info";
    }

    //密码修改
    @PutMapping("/changePwd")
    public String changePwd(@RequestParam("mpass") String mpass, //得到原密码
                            @RequestParam("newpass") String newpass, //得到新密码
                            HttpSession session) {
        LoginUser loguser = loginService.Selectbyid(session.getAttribute("loginuserid").toString());
        if (loguser.getPassword().equals(mpass)) { //看原密码是否一致
            int i = loginService.updataPwd(session.getAttribute("loginuserid").toString(), newpass);
            if (i == 1) {
                return "changePweSuccess";
            }
            if (i == 0) {
                return "changePweFail";
            }
        } else {
            return "changePweFail";
        }
        return null;
    }
}
