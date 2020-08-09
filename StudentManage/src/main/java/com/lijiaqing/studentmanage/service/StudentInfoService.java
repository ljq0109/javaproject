package com.lijiaqing.studentmanage.service;

import com.lijiaqing.studentmanage.entity.Student;

import java.util.List;

public interface StudentInfoService {

    //对数据库中的学生表按stu_id进行查找操作
    Student showStuInfo(String stu_id);

    //对学生表全部查找
    List<Student> selectAll();

    //对学生表进行添加操作
    int addStudent(String stu_id, String stu_name, String stu_sex, String stu_birth, String stu_college, String stu_subject, String stu_class, String intime,
                   String stu_state,String sanhao);

    //对学生表按照stu_id进行修改
    int stuUpdateByid(String stu_id, String stu_name, String stu_sex, String stu_birth, String stu_college, String stu_subject, String stu_class, String intime,
                      String stu_state);

    //对学生表按照stu_id进行删除操作
    int delete(String stu_id);

    //退学，结业，毕业处理
    int updatestate(String stu_id, String stu_state);

    //三好学生处理
    int updatesanhao(String stu_id, String sanhao);

    //查找退学，结业，毕业学生
    List<Student> selectBystate(String stu_state);

    //查找三好学生
    List<Student> selectBysanhao();
}
