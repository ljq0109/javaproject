package com.lijiaqing.studentmanage.service;

import com.lijiaqing.studentmanage.entity.College;

import java.util.List;

public interface CollegeService {

    //对college_infor表按照college_id进行查找
    College selectByid(String college_id);

    //对college_infor表进行全部查找
    List<College> selectAll();
}
