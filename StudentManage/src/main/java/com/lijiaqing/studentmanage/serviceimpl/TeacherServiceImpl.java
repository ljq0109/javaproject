package com.lijiaqing.studentmanage.serviceimpl;

import com.lijiaqing.studentmanage.dao.TeacherDao;
import com.lijiaqing.studentmanage.entity.Teacher;
import com.lijiaqing.studentmanage.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> selectAll() {
        return teacherDao.selectAll();
    }

    @Override
    public Teacher selectByid(String tea_id) {
        return teacherDao.selectByid(tea_id);
    }

    @Override
    public int addTeacher(String tea_id, String tea_name, String tea_sex, String tea_college) {
        return teacherDao.addTeacher(tea_id, tea_name, tea_sex, tea_college);
    }

    @Override
    public int deleteByid(String tea_id) {
        return teacherDao.deleteByid(tea_id);
    }

    @Override
    public int updateByid(String tea_id, String tea_name, String tea_sex, String tea_college) {
        return teacherDao.updateByid(tea_id, tea_name, tea_sex, tea_college);
    }
}
