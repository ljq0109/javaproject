package com.lijiaqing.studentmanage.service;

import com.lijiaqing.studentmanage.entity.Subject;

import java.util.List;

public interface SubjectService {

    //对subject_infor（专业信息表）按照college_id进行查找
    Subject selectByid(String college_id);

    //全部查找
    List<Subject> selectAll();
}
