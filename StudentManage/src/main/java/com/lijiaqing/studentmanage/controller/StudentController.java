package com.lijiaqing.studentmanage.controller;


import com.lijiaqing.studentmanage.entity.*;
import com.lijiaqing.studentmanage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentInfoService studentinfoService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private GradeService gradeService;


    //显示学生自己的个人信息页面
    @GetMapping("/stu_Infor")
    public String jumpStuInfo(HttpSession session, ModelMap modelMap) {
        Student stu = new Student();
        stu = studentinfoService.showStuInfo(session.getAttribute("loginuserid").toString());
        modelMap.put("stu", stu);
        return "stu/stu_Info";
    }

    //学生修改密码界面
    @GetMapping("/stu_changePass")
    public String exchangePass(HttpSession session, ModelMap modelMap) {
        LoginUser loguser = loginService.Selectbyid(session.getAttribute("loginuserid").toString());
        modelMap.put("loguser", loguser);
        return "changePass";
    }

    //查看自己的成绩
    @GetMapping("/stu_Grade")
    public String showGrade(HttpSession session, ModelMap modelMap) {
        Student student = studentinfoService.showStuInfo(session.getAttribute("loginuserid").toString());
        List<Grade> list = gradeService.selectBystuid(session.getAttribute("loginuserid").toString());
        modelMap.put("colist", list);
        modelMap.put("stu", student);
        return "stu/stu_grade";
    }
}
