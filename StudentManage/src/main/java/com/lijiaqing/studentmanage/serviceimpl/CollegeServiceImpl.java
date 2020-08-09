package com.lijiaqing.studentmanage.serviceimpl;

import com.lijiaqing.studentmanage.dao.CollegeDao;
import com.lijiaqing.studentmanage.entity.College;
import com.lijiaqing.studentmanage.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeDao collegeDao;


    @Override
    public College selectByid(String college_id) {
        return collegeDao.selectByid(college_id);
    }

    @Override
    public List<College> selectAll() {
        return collegeDao.selectAll();
    }
}
