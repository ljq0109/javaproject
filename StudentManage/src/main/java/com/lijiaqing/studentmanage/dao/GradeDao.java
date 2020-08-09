package com.lijiaqing.studentmanage.dao;

import com.lijiaqing.studentmanage.entity.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GradeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //对成绩表进行全部查找
    public List<Grade> selectAll() {
        String sql = "select * from student_infor,grade_infor,teacher_infors,college_infor where grade_infor.cou_teacher = teacher_infors.tea_id and grade_infor.stu_college = college_infor.college_id and student_infor.stu_id=grade_infor.stu_id and student_infor.stu_state='1'";
        List<Grade> gradeList = new ArrayList<>();
        gradeList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Grade>>() {
            @Override
            public List<Grade> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Grade> gradeList1 = new ArrayList<>();
                while (rs.next()) {
                    Grade grade = new Grade();
                    grade.setStu_id(rs.getString("stu_id"));
                    grade.setCou_id(rs.getString("cou_id"));
                    grade.setCou_name(rs.getString("cou_name"));
                    grade.setGrade(rs.getFloat("grade"));
                    grade.setStu_name(rs.getString("stu_name"));
                    grade.setTea_id(rs.getString("cou_teacher"));
                    grade.setTea_name(rs.getString("tea_name"));
                    grade.setStu_college(rs.getString("stu_college"));
                    grade.setStu_collegename(rs.getString("college_name"));
                    gradeList1.add(grade);
                }
                return gradeList1;
            }
        });
        return gradeList;
    }

    //对成绩表按学号查找
    public List<Grade> selectBystuid(String stu_id) {
        String sql = "select * from grade_infor,teacher_infors,college_infor,student_infor where grade_infor.stu_id=? and grade_infor.cou_teacher = teacher_infors.tea_id and grade_infor.stu_college = college_infor.college_id and student_infor.stu_id=grade_infor.stu_id and student_infor.stu_state='1'";
        List<Grade> gradeList = new ArrayList<>();
        gradeList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Grade>>() {
            @Override
            public List<Grade> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Grade> gradeList1 = new ArrayList<>();
                while (rs.next()) {
                    Grade grade = new Grade();
                    grade.setStu_id(rs.getString("stu_id"));
                    grade.setCou_id(rs.getString("cou_id"));
                    grade.setCou_name(rs.getString("cou_name"));
                    grade.setGrade(rs.getFloat("grade"));
                    grade.setStu_name(rs.getString("stu_name"));
                    grade.setTea_id(rs.getString("cou_teacher"));
                    grade.setTea_name(rs.getString("tea_name"));
                    grade.setStu_college(rs.getString("stu_college"));
                    grade.setStu_collegename(rs.getString("college_name"));
                    gradeList1.add(grade);
                }
                return gradeList1;
            }
        }, stu_id);
        return gradeList;

    }

    //对成绩表按教师工号查找
    public List<Grade> selectByteaid(String tea_id) {
        String sql = "select * from grade_infor,teacher_infors,college_infor where grade_infor.cou_teacher=? and grade_infor.cou_teacher = teacher_infors.tea_id and grade_infor.stu_college = college_infor.college_id";
        List<Grade> gradeList = new ArrayList<>();
        gradeList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Grade>>() {
            @Override
            public List<Grade> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Grade> gradeList1 = new ArrayList<>();
                while (rs.next()) {
                    Grade grade = new Grade();
                    grade.setStu_id(rs.getString("stu_id"));
                    grade.setCou_id(rs.getString("cou_id"));
                    grade.setCou_name(rs.getString("cou_name"));
                    grade.setGrade(rs.getFloat("grade"));
                    grade.setStu_name(rs.getString("stu_name"));
                    grade.setTea_id(rs.getString("cou_teacher"));
                    grade.setTea_name(rs.getString("tea_name"));
                    grade.setStu_college(rs.getString("stu_college"));
                    grade.setStu_collegename(rs.getString("college_name"));
                    gradeList1.add(grade);
                }
                return gradeList1;
            }
        }, tea_id);
        return gradeList;
    }

    //对成绩表按学号，课程号查找
    public Grade selectByid(String stu_id, String cou_id) {
        String sql = "select * from grade_infor,teacher_infors,college_infor,student_infor where grade_infor.stu_id=? and grade_infor.cou_id=? and grade_infor.cou_teacher = teacher_infors.tea_id and grade_infor.stu_college = college_infor.college_id and student_infor.stu_id=grade_infor.stu_id and student_infor.stu_state='1'";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Grade>() {
            @Override
            public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
                Grade grade = new Grade();
                grade.setStu_id(rs.getString("stu_id"));
                grade.setCou_id(rs.getString("cou_id"));
                grade.setCou_name(rs.getString("cou_name"));
                grade.setGrade(rs.getFloat("grade"));
                grade.setStu_name(rs.getString("stu_name"));
                grade.setTea_id(rs.getString("cou_teacher"));
                grade.setTea_name(rs.getString("tea_name"));
                grade.setStu_college(rs.getString("stu_college"));
                grade.setStu_collegename(rs.getString("college_name"));
                return grade;
            }
        }, new Object[]{stu_id, cou_id});
    }

    //对成绩表按学号，课程号修改
    public int updateByid(String grade, String stu_id, String cou_id) {
        String sql = "update grade_infor set grade=? where stu_id=? and cou_id=?";
        return jdbcTemplate.update(sql, new Object[]{grade, stu_id, cou_id});
    }

    //对成绩表进行增加操作
    public int addGrade(String stu_id, String cou_id, String grade, String stu_name, String cou_name, String tea_id, String college_id) {
        String sql = "insert into grade_infor values(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{stu_id, cou_id, grade, stu_name, cou_name, tea_id, college_id});
    }

    //对成绩表按照学号，课程号进行删除
    public int deleteByid(String stu_id, String cou_id) {
        String sql = "delete from grade_infor where stu_id=? and cou_id=?";
        return jdbcTemplate.update(sql, new Object[]{stu_id, cou_id});
    }
}
