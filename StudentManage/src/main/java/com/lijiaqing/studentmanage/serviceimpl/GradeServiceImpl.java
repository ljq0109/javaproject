package com.lijiaqing.studentmanage.serviceimpl;

import com.lijiaqing.studentmanage.dao.GradeDao;
import com.lijiaqing.studentmanage.entity.Grade;
import com.lijiaqing.studentmanage.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeDao gradeDao;

    @Override
    public List<Grade> selectAll() {
        return gradeDao.selectAll();
    }

    @Override
    public List<Grade> selectBystuid(String stu_id) {
        return gradeDao.selectBystuid(stu_id);
    }

    @Override
    public List<Grade> selectByteaid(String tea_id) {
        return gradeDao.selectByteaid(tea_id);
    }

    @Override
    public Grade selectByid(String stu_id, String cou_id) {
        return gradeDao.selectByid(stu_id, cou_id);
    }

    @Override
    public int updateByid(String grade, String stu_id, String cou_id) {
        return gradeDao.updateByid(grade, stu_id, cou_id);
    }

    @Override
    public int addGrade(String stu_id, String cou_id, String grade, String stu_name, String cou_name, String tea_id, String college_id) {
        return gradeDao.addGrade(stu_id, cou_id, grade, stu_name, cou_name, tea_id, college_id);
    }

    @Override
    public int deleteByid(String stu_id, String cou_id) {
        return gradeDao.deleteByid(stu_id, cou_id);
    }
}
