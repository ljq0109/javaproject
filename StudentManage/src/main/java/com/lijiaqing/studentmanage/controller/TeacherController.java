package com.lijiaqing.studentmanage.controller;

import com.lijiaqing.studentmanage.entity.*;
import com.lijiaqing.studentmanage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentInfoService studentInfoService;

    //显示教师自己的信息
    @GetMapping("/tea_Infor")
    public String showTea_Infor(HttpSession session, ModelMap modelMap) {
        Teacher teacher = teacherService.selectByid(session.getAttribute("loginuserid").toString());
        modelMap.put("tea", teacher);
        College college = collegeService.selectByid(teacher.getTea_college());
        modelMap.put("col", college);
        return "tea/tea_Info";
    }

    //教师修改密码界面
    @GetMapping("/tea_changePass")
    public String exchangePass(HttpSession session, ModelMap modelMap) {
        LoginUser loguser = loginService.Selectbyid(session.getAttribute("loginuserid").toString());
        modelMap.put("loguser", loguser);
        return "changePass";
    }

    //密码修改同学生

    //查看学生的成绩列表
    @GetMapping("/liststu_Grade")
    public String listsGrade(HttpSession session, ModelMap modelMap) {
        List<Grade> list = gradeService.selectByteaid(session.getAttribute("loginuserid").toString());
        modelMap.put("stulist", list);
        return "tea/tea_stulist";
    }

    //按照学生学号查找成绩
    @PostMapping("/selectstulist")
    public String selectstulist(String stu_id,
                                ModelMap modelMap) {
        List<Grade> sslist = gradeService.selectBystuid(stu_id);
        modelMap.put("stulist", sslist);
        return "tea/tea_stulis";
    }

    //查找教师自己能录入的学科，并选择录入
    @GetMapping("/selectcourse")
    public String selectcourse(HttpSession session, ModelMap modelMap) {
        List<Course> courseList = courseService.selectByteaid(session.getAttribute("loginuserid").toString());
        modelMap.put("courseList", courseList);
        return "tea/tea_coulist";
    }

    //转到录入成绩界面
    @GetMapping("/addgrade/{cou_id}")
    public String addgarde(@PathVariable("cou_id") String cou_id, ModelMap modelMap) {
        Course course = courseService.selectById(cou_id);
        modelMap.put("course", course);
        return "tea/tea_addgrade";
    }

    //取得录入的成绩并加入数据库
    @PostMapping("/addstugrade")
    public String addstugrade(@RequestParam("cou_id") String cou_id,
                              @RequestParam("cou_name") String cou_name,
                              @RequestParam("stu_id") String stu_id,
                              @RequestParam("stu_name") String stu_name,
                              @RequestParam("grade") String grade,
                              HttpSession session,
                              ModelMap modelMap) {
        String tea_id = session.getAttribute("loginuserid").toString();
        Student student = studentInfoService.showStuInfo(stu_id);
        try {
            int i = gradeService.addGrade(stu_id, cou_id, grade, stu_name, cou_name, tea_id,student.getStu_college());
            if (i != 0) {
                return "redirect:/liststu_Grade";
            } else {
                Course course = courseService.selectById(cou_id);
                modelMap.put("course", course);
                modelMap.put("msg", "录入成绩出错，请重新录入");
                return "tea/tea_addgrade";
            }
        } catch (Exception e){
            Course course = courseService.selectById(cou_id);
            modelMap.put("course", course);
            modelMap.put("msg", "录入成绩出错,请重新录入");
            return "tea/tea_addgrade";
        }
    }

}
