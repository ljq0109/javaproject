package com.lijiaqing.studentmanage.serviceimpl;


import com.lijiaqing.studentmanage.dao.SubjectDao;
import com.lijiaqing.studentmanage.entity.Subject;
import com.lijiaqing.studentmanage.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public Subject selectByid(String college_id) {
        return subjectDao.selectByid(college_id);
    }

    @Override
    public List<Subject> selectAll() {
        return subjectDao.selectAll();
    }
}
