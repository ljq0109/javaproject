package com.lijiaqing.studentmanage.serviceimpl;

import com.lijiaqing.studentmanage.dao.StuInfoDao;
import com.lijiaqing.studentmanage.entity.Student;
import com.lijiaqing.studentmanage.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    private StuInfoDao stuInfoDao;

    @Override
    public Student showStuInfo(String stu_id){
        return stuInfoDao.showStuInfo(stu_id);
    }

    @Override
    public List<Student> selectAll() {
       return stuInfoDao.selectAll();
    }

    @Override
    public int addStudent(String stu_id, String stu_name, String stu_sex, String stu_birth, String stu_college, String stu_subject, String stu_class,String intime,
                          String stu_state,String sanhao) {
        return stuInfoDao.addStudent(stu_id,stu_name,stu_sex,stu_birth,stu_college,stu_subject,stu_class,intime,stu_state,sanhao);
    }

    @Override
    public int stuUpdateByid(String stu_id, String stu_name, String stu_sex, String stu_birth, String stu_college, String stu_subject, String stu_class,String intime,
                             String stu_state) {
        return stuInfoDao.stuUpdateByid(stu_id,stu_name,stu_sex,stu_birth,stu_college,stu_subject,stu_class,intime,stu_state);
    }

    @Override
    public int delete(String stu_id) {
        return stuInfoDao.delete(stu_id);
    }

    @Override
    public int updatestate(String stu_id, String stu_state) {
        return stuInfoDao.updatestate(stu_id,stu_state);
    }

    @Override
    public int updatesanhao(String stu_id, String sanhao) {
        return stuInfoDao.updatesanhao(stu_id,sanhao);
    }

    @Override
    public List<Student> selectBystate(String stu_state) {
        return stuInfoDao.selectBystate(stu_state);
    }

    @Override
    public List<Student> selectBysanhao() {
        return stuInfoDao.selectBysanhao();
    }
}
