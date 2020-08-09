package com.lijiaqing.studentmanage.serviceimpl;

import com.lijiaqing.studentmanage.dao.SimpleTeacherDao;
import com.lijiaqing.studentmanage.service.SimpleTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class SimpleTeacherImpl implements SimpleTeacherService {

    @Autowired
    private SimpleTeacherDao simpleTeacherDao;

    @Override
    public int addTeacher(String tea_id, String tea_name) {
        return simpleTeacherDao.addTeacher(tea_id,tea_name);
    }
}
