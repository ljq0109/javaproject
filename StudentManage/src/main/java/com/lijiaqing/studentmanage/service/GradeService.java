package com.lijiaqing.studentmanage.service;

import com.lijiaqing.studentmanage.entity.Grade;

import java.util.List;

public interface GradeService {

    //对成绩表进行全部查找
    List<Grade> selectAll();

    //对成绩表按学号查找
    List<Grade> selectBystuid(String stu_id);

    //对成绩表按教师工号查找
    List<Grade> selectByteaid(String tea_id);

    //对成绩表按学号，课程号查找
    Grade selectByid(String stu_id, String cou_id);

    //对成绩表按学号，课程号修改
    int updateByid(String grade, String stu_id, String cou_id);

    //对成绩表进行增加操作
    int addGrade(String stu_id, String cou_id, String grade, String stu_name, String cou_name, String tea_id, String college_id);

    //对成绩表按照学号，课程号进行删除
    int deleteByid(String stu_id, String cou_id);
}
