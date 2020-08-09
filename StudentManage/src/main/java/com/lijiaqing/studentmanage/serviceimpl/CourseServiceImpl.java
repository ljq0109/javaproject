package com.lijiaqing.studentmanage.serviceimpl;

import com.lijiaqing.studentmanage.dao.CourseDao;
import com.lijiaqing.studentmanage.entity.Course;
import com.lijiaqing.studentmanage.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {


    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> selectByteaid(String tea_id) {
        return courseDao.selectByteaid(tea_id);
    }

    @Override
    public Course selectById(String cou_id) {
        return courseDao.selectById(cou_id);
    }

    @Override
    public List<Course> selectAll() {
        return courseDao.selectAll();
    }

    @Override
    public int addCourse(String cou_id, String cou_name, String cou_college, float cou_credit, String cou_teacher) {
        return courseDao.addCourse(cou_id,cou_name,cou_college,cou_credit,cou_teacher);
    }

    @Override
    public int updateByid(String cou_id, String cou_name, String cou_college, float cou_credit, String cou_teacher) {
        return courseDao.updateByid(cou_id,cou_name,cou_college,cou_credit,cou_teacher);
    }

    @Override
    public int deleteByid(String cou_id) {
        return courseDao.deleteByid(cou_id);
    }

}
