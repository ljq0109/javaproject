package com.lijiaqing.studentmanage.controller;


import com.lijiaqing.studentmanage.entity.*;
import com.lijiaqing.studentmanage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ManagerController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private StateService stateService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private SimpleTeacherService simpleTeacherService;


    //显示管理员的简单信息
    @GetMapping("/showManInfo")
    public String showManInfo(HttpSession session, ModelMap modelMap) {
        LoginUser loginUser = loginService.Selectbyid(session.getAttribute("loginuserid").toString());
        modelMap.put("loginUser", loginUser);
        return "man/man_Info";
    }

    //管理员修改密码界面
    @GetMapping("/changemanpass")
    public String changemanpass(HttpSession session, ModelMap modelMap) {

        LoginUser loginUser = loginService.Selectbyid(session.getAttribute("loginuserid").toString());
        modelMap.put("loguser", loginUser);
        return "changePass";
    }

    //查看学生用户简单信息
    @GetMapping("/stulist")
    public String stulist(ModelMap modelMap) {
        List<Student> studentList = studentInfoService.selectAll();
        modelMap.put("studentList", studentList);
        return "man/man_stulist";
    }

    //查找学生信息
    @PostMapping("/manselectstulist")
    public String manstu(@RequestParam("stu_id") String stu_id, ModelMap modelMap) {
        Student studentList = studentInfoService.showStuInfo(stu_id);
        modelMap.put("studentList", studentList);
        return "man/man_stulis";
    }


    //重置学生密码功能
    @GetMapping("/repassstu/{stu_id}")
    public String restupass(@PathVariable("stu_id") String stu_id, ModelMap modelMap) {
        try {
            int i = loginService.updataPwd(stu_id, stu_id);
            if (i == 1) {
                return "redirect:/stulist";
            } else
                modelMap.put("msg", "重置密码错误");
            return "redirect:/stulist";
        } catch (Exception e) {
            modelMap.put("msg", "重置密码错误");
            return "redirect:/stulist";
        }
    }

    //教师列表
    @GetMapping("/tealist")
    public String tealist(ModelMap modelMap) {
        try {
            List<Teacher> teacherList = teacherService.selectAll();
            modelMap.put("teacherList", teacherList);
            return "man/man_tealist";
        } catch (Exception e) {
            modelMap.put("msg", "暂无用户");
            return "man/man_tealis";
        }
    }

    //查找教师信息
    @PostMapping("/selecttealist")
    public String selecttealist(@RequestParam("tea_id") String tea_id, ModelMap modelMap) {
        try {
            Teacher teacher = teacherService.selectByid(tea_id);
            modelMap.put("teacherList", teacher);
            return "man/man_tealis";
        } catch (Exception e) {
            modelMap.put("msg", "查找的用户不存在"); //如果没有这位老师，输出
            List<Teacher> teacherList = teacherService.selectAll();
            modelMap.put("teacherList", teacherList);
            return "man/man_tealist";
        }
    }

    //跳转到添加教师信息界面
    @GetMapping("/toaddtea")
    public String toaddtea(ModelMap modelMap) {
        List<College> collegeList = collegeService.selectAll();
        modelMap.put("collegeList", collegeList);
        return "man/man_addtea";
    }

    //添加教师信息
    @PostMapping("/addtea")
    public String addtea(Teacher teacher, @RequestParam("role") String role, ModelMap modelMap) {
        try {
            teacherService.addTeacher(teacher.getTea_id(), teacher.getTea_name(), teacher.getTea_sex(), teacher.getTea_college());
            simpleTeacherService.addTeacher(teacher.getTea_id(), teacher.getTea_name());
            try {
                loginService.addLoginuser(teacher.getTea_id(), teacher.getTea_id(), role, teacher.getTea_name());
            } catch (Exception e) {
                List<College> collegeList = collegeService.selectAll();
                modelMap.put("collegeList", collegeList);
                modelMap.put("msg", "添加信息失败，请修改后重新添加");
                return "man/man_addtea";
            }
        } catch (Exception e) {
            List<College> collegeList = collegeService.selectAll();
            modelMap.put("collegeList", collegeList);
            modelMap.put("msg", "添加信息失败，请修改后重新添加");
            return "man/man_addtea";
        }
        //返回教师列表界面
        //重定向到
        return "redirect:/tealist";
    }


    //重置教师密码功能
    @GetMapping("/repasstea/{tea_id}")
    public String reteapass(@PathVariable("tea_id") String tea_id, ModelMap modelMap) {
        try {
            int i = loginService.updataPwd(tea_id, tea_id);
            if (i == 1) {
                return "redirect:/tealist";
            } else
                modelMap.put("msg", "重置密码错误");
            return "redirect:/tealist";
        } catch (Exception e) {
            modelMap.put("msg", "重置密码错误");
            return "redirect:/tealist";
        }
    }

    //跳转到修改教师信息页面
    @GetMapping("/changeinfo/{tea_id}")
    public String tochangteainfo(@PathVariable("tea_id") String tea_id, ModelMap modelMap) {
        Teacher teacher = teacherService.selectByid(tea_id);
        modelMap.put("teacher", teacher);
        //显示院系列表
        List<College> collegeList = collegeService.selectAll();
        modelMap.put("collegeList", collegeList);
        //修改添加二合一
        return "man/man_addtea";
    }

    //教师修改
    @PutMapping("/addtea")
    public String changteainfo(Teacher teacher) {
        try {
            teacherService.updateByid(teacher.getTea_id(), teacher.getTea_name(), teacher.getTea_sex(), teacher.getTea_college());
            return "redirect:/tealist";
        } catch (Exception e) {
            return "redirect:/changeinfo/{tea_id}";
        }
    }

    //删除教师信息
    @GetMapping("/deletetea/{tea_id}")
    public String deletetea(@PathVariable("tea_id") String tea_id) {
        teacherService.deleteByid(tea_id);
        loginService.deleteByid(tea_id);
        return "redirect:/tealist";
    }

    //跳转到学籍列表界面
    @GetMapping("/showstuinfo")
    public String toshowstuinfo(ModelMap modelMap) {
        List<Student> studentList = studentInfoService.selectAll();
        modelMap.put("studentList", studentList);
        return "man/man_stuinforlist";
    }


    //通过学生id来搜索学籍的信息
    @PostMapping("/selectstuinforlist")
    public String selectstuinforlist(@RequestParam("stu_id") String stu_id, ModelMap modelMap) {
        try {
            Student student = studentInfoService.showStuInfo(stu_id);
            modelMap.put("studentList", student);
            return "man/man_stuinfolist";
        } catch (Exception e) {
            modelMap.put("msg", "查找的用户不存在"); //如果没有这门课程，输出
            List<Student> studentList = studentInfoService.selectAll();
            modelMap.put("studentList", studentList);
            return "man/man_stuinforlist";
        }
    }

    //跳转到添加学籍信息界面
    @GetMapping("/toaddstuinfor")
    public String toaddstuinfor(ModelMap modelMap) {
        List<State> statesList = stateService.selectAll();
        List<College> collegeList = collegeService.selectAll();
        List<Subject> subjectsList = subjectService.selectAll();
        modelMap.put("statesList", statesList);
        modelMap.put("collegeList", collegeList);
        modelMap.put("subjectsList", subjectsList);
        return "man/man_addstu";
    }

    //添加学籍信息
    @PostMapping("/addstu")
    public String addstu(Student student, @RequestParam("role") String role,
                         @RequestParam("sanhao") String sanhao,ModelMap modelMap) {
        try {
            studentInfoService.addStudent(student.stu_id, student.stu_name, student.stu_sex, student.stu_birth, student.stu_college, student.stu_subject, student.stu_class, student.intime, student.stu_state, sanhao);
            loginService.addLoginuser(student.stu_id, student.stu_id, role, student.stu_name);
            return "redirect:/showstuinfo";
        } catch (Exception e) {
            List<State> statesList = stateService.selectAll();
            List<College> collegeList = collegeService.selectAll();
            List<Subject> subjectsList = subjectService.selectAll();
            modelMap.put("statesList", statesList);
            modelMap.put("collegeList", collegeList);
            modelMap.put("subjectsList", subjectsList);
            modelMap.put("msg","添加信息失败，请修改后重新添加");
            return "man/man_addstu";
        }
    }

    //跳转到修改学籍信息界面
    @GetMapping("/changestuinfor/{stu_id}")
    public String tochangestuinfor(@PathVariable("stu_id") String stu_id, ModelMap modelMap) {
        Student student = studentInfoService.showStuInfo(stu_id);
        List<State> statesList = stateService.selectAll();
        List<College> collegeList = collegeService.selectAll();
        List<Subject> subjectsList = subjectService.selectAll();
        modelMap.put("statesList", statesList);
        modelMap.put("collegeList", collegeList);
        modelMap.put("subjectsList", subjectsList);
        modelMap.put("student", student);
        return "man/man_addstu";
    }


    //学籍修改
    @PutMapping("/addstu")
    public String changstuinfor(Student student) {
        try {
            studentInfoService.stuUpdateByid(student.stu_id, student.stu_name, student.stu_sex, student.stu_birth, student.stu_college, student.stu_subject, student.stu_class, student.intime, student.stu_state);
            return "redirect:/showstuinfo";
        } catch (Exception e) {
            return "redirect:/changestuinfor/{stu_id}";
        }
    }


    //删除学籍信息
    @GetMapping("/deletestuinfor/{stu_id}")
    public String deletestuinfor(@PathVariable("stu_id") String stu_id) {
        studentInfoService.delete(stu_id);
        loginService.deleteByid(stu_id);
        return "redirect:/showstuinfo";
    }


    //跳转到课程列表
    @GetMapping("/showcou")
    public String showcou(ModelMap modelMap) {
        List<Course> courseList = courseService.selectAll();
        modelMap.put("courseList", courseList);
        return "man/man_coulist";
    }

    //通过课程id来搜索课程的信息
    @PostMapping("/selectcoulist")
    public String selectcou(@RequestParam("cou_id") String cou_id, ModelMap modelMap) {
        try {
            Course course = courseService.selectById(cou_id);
            modelMap.put("courseList", course);
            return "man/man_coulis";
        } catch (Exception e) {
            modelMap.put("msg", "查找的课程不存在"); //如果没有这门课程，输出
            List<Course> courseList = courseService.selectAll();
            modelMap.put("courseList", courseList);
            return "man/man_coulist";
        }
    }

    //跳转到添加课程信息界面
    @GetMapping("/toaddcou")
    public String toaddcou(ModelMap modelMap) {
        List<College> collegeList = collegeService.selectAll();
        List<Teacher> teacherList = teacherService.selectAll();
        modelMap.put("collegeList", collegeList);
        modelMap.put("teacherList", teacherList);
        return "man/man_addcou";
    }

    //添加课程信息
    @PostMapping("/addcou")
    public String addcou(Course course, ModelMap modelMap) {
        try {
            courseService.addCourse(course.getCou_id(), course.getCou_name(), course.getCou_college(), course.getCou_credit(), course.getCou_teacher());
            return "redirect:/showcou";
        } catch (Exception e) {
            modelMap.put("msg", "添加信息失败，请修改后重新添加");
            List<College> collegeList = collegeService.selectAll();
            List<Teacher> teacherList = teacherService.selectAll();
            modelMap.put("collegeList", collegeList);
            modelMap.put("teacherList", teacherList);
            return "man/man_addcou";
        }
    }

    //跳转到修改课程信息页面
    @GetMapping("/changecou/{cou_id}")
    public String tochangecou(@PathVariable("cou_id") String cou_id, ModelMap modelMap) {
        Course course = courseService.selectById(cou_id);
        List<College> collegeList = collegeService.selectAll();
        List<Teacher> teacherList = teacherService.selectAll();
        modelMap.put("collegeList", collegeList);
        modelMap.put("teacherList", teacherList);
        modelMap.put("course", course);
        return "man/man_addcou";
    }

    //修改课程信息
    @PutMapping("/addcou")
    public String changecou(Course course) {
        try {
            courseService.updateByid(course.getCou_id(), course.getCou_name(), course.getCou_college(), course.getCou_credit(), course.getCou_teacher());
            return "redirect:showcou";
        } catch (Exception e) {
            return "redirect:/changecou/{cou_id}";
        }
    }

    //删除课程信息
    @GetMapping("/deletecou/{cou_id}")
    public String deletecou(@PathVariable("cou_id") String cou_id) {
        courseService.deleteByid(cou_id);
        return "redirect:/showcou";
    }

    //显示成绩信息列表
    @GetMapping("/showgrade")
    public String showgrade(ModelMap modelMap) {
        List<Grade> gradeList = gradeService.selectAll();
        modelMap.put("gradeList", gradeList);
        return "man/man_gradelist";
    }

    //跳转到按照学生学号查找
    @GetMapping("/selectbystuid")
    public String toselectbystuid() {
        return "man/man_selgbystuid";
    }

    //按照学生学号查找
    @PostMapping("/selgbystuid")
    public String selgbystuid(@RequestParam("stu_id") String stu_id, ModelMap modelMap) {
        List<Grade> gradeList = gradeService.selectBystuid(stu_id);
        modelMap.put("gradeList", gradeList);
        return "man/man_gradelist";
    }

    //跳转到按照教职工号查找
    @GetMapping("/selectbyteaid")
    public String toselectbyteaid() {
        return "man/man_selgbyteaid";
    }

    //按照教职工号查找
    @PostMapping("/selgbyteaid")
    public String selgbyteaid(@RequestParam("tea_id") String tea_id, ModelMap modelMap) {
        List<Grade> gradeList = gradeService.selectByteaid(tea_id);
        modelMap.put("gradeList", gradeList);
        return "man/man_gradelist";
    }

    //跳转到按照学号和课程号查找
    @GetMapping("/selectbystucouid")
    public String toselectbystucouid() {
        return "man/man_selgbystucouid";
    }

    //按照学号和课程号查找
    @PostMapping("/selgbystucouid")
    public String selgbystucouid(@RequestParam("stu_id") String stu_id,
                                 @RequestParam("cou_id") String cou_id,
                                 ModelMap modelMap) {
        try {
            Grade grade = gradeService.selectByid(stu_id, cou_id);
            modelMap.put("gradeList", grade);
            return "man/man_gradelist";
        } catch (Exception e) {
            return "man/man_select404";
        }
    }

    //跳转到修改成绩信息
    @GetMapping("/changegradeinfo/{stu_id}/{cou_id}")
    public String tochangegradeinfo(@PathVariable("stu_id") String stu_id,
                                    @PathVariable("cou_id") String cou_id,
                                    ModelMap modelMap) {
        Grade grade = gradeService.selectByid(stu_id, cou_id);
        modelMap.put("grade", grade);
        return "man/man_changgrade";
    }

    //修改成绩信息
    @PostMapping("/changegrade")
    public String changegrade(@RequestParam("stu_id") String stu_id,
                              @RequestParam("cou_id") String cou_id,
                              @RequestParam("grade") String grade) {
        gradeService.updateByid(grade, stu_id, cou_id);
        return "redirect:/showgrade";
    }

    //删除成绩信息
    @GetMapping("/deletegradeinfo/{stu_id}/{cou_id}")
    public String deletegradeinfo(@PathVariable("stu_id") String stu_id,
                                  @PathVariable("cou_id") String cou_id) {
        gradeService.deleteByid(stu_id, cou_id);
        return "redirect:/showgrade";
    }

    //设置三好学生
    @GetMapping("/sanhao/{stu_id}")
    public String sanhao(@PathVariable("stu_id") String stu_id) {
        studentInfoService.updatesanhao(stu_id, "是");
        return "redirect:/stulist";
    }

    //查看所有的三好学生
    @GetMapping("/zsanhao")
    public String showsanhao(ModelMap modelMap) {
        List<Student> studentList = studentInfoService.selectBysanhao();
        modelMap.put("studentList", studentList);
        return "man/man_sanhaolist";
    }

    //退学处理
    @GetMapping("/tuixue/{stu_id}")
    public String tuixue(@PathVariable("stu_id") String stu_id) {
        studentInfoService.updatestate(stu_id, "4");
        loginService.deleteByid(stu_id);
        return "redirect:/showstuinfo";
    }

    //毕业处理
    @GetMapping("/biye/{stu_id}")
    public String biye(@PathVariable("stu_id") String stu_id) {
        studentInfoService.updatestate(stu_id, "2");
        loginService.deleteByid(stu_id);
        return "redirect:/showstuinfo";
    }

    //结业处理
    @GetMapping("/jieye/{stu_id}")
    public String jieye(@PathVariable("stu_id") String stu_id) {
        studentInfoService.updatestate(stu_id, "3");
        loginService.deleteByid(stu_id);
        return "redirect:/showstuinfo";
    }

    //显示退学学生
    @GetMapping("/ztuixue")
    public String showtuixue(ModelMap modelMap) {
        List<Student> studentList = studentInfoService.selectBystate("4");
        modelMap.put("studentList", studentList);
        return "man/man_disinlist";
    }

    //显示毕业学生
    @GetMapping("/zbiye")
    public String showbiye(ModelMap modelMap) {
        List<Student> studentList = studentInfoService.selectBystate("2");
        modelMap.put("studentList", studentList);
        return "man/man_disinlist";
    }

    //显示结业学生
    @GetMapping("/zjieye")
    public String showjieye(ModelMap modelMap) {
        List<Student> studentList = studentInfoService.selectBystate("3");
        modelMap.put("studentList", studentList);
        return "man/man_disinlist";
    }
}
