package com.lijiaqing.studentmanage.service;

import com.lijiaqing.studentmanage.entity.Teacher;

import java.util.List;

public interface TeacherService {

    //对教师表进行全部查找操作
    List<Teacher> selectAll();

    //对教师表按照id进行查找
    Teacher selectByid(String tea_id);

    //对教师表进行增加操作
    int addTeacher(String tea_id,
                   String tea_name,
                   String tea_sex,
                   String tea_college);

    //对教师表按id进行删除操作
    int deleteByid(String tea_id);

    //对教师表按照id进行修改
    int updateByid(String tea_id,
                   String tea_name,
                   String tea_sex,
                   String tea_college);
}
