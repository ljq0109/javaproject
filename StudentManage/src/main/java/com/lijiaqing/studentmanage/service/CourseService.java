package com.lijiaqing.studentmanage.service;


import com.lijiaqing.studentmanage.entity.Course;

import java.util.List;

public interface CourseService {

    //按照教师的职工号进行查找
    List<Course> selectByteaid(String tea_id);

    //按照课程号查找课程信息
    Course selectById(String cou_id);

    //对课程表进行全部查找
    List<Course> selectAll();

    //对课程表进行增加操作
    int addCourse(String cou_id,
                  String cou_name,
                  String cou_college,
                  float cou_credit,
                  String cou_teacher);

    //对课程表按id进行修改
    int updateByid(String cou_id,
                   String cou_name,
                   String cou_college,
                   float cou_credit,
                   String cou_teacher);

    //对课程表按ID进行删除
    int deleteByid(String cou_id);
}
