package com.lijiaqing.studentmanage.dao;


import com.lijiaqing.studentmanage.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StuInfoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //对数据库中的学生表按stu_id进行查找操作
    public Student showStuInfo(String stu_id) {
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
        String sql = "select * from student_infor,college_infor,subject_infor,state where student_infor.stu_college=college_infor.college_id and student_infor.stu_subject=subject_infor.sub_id and student_infor.stu_state = state.state_id and student_infor.stu_id=?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setStu_id(rs.getString("stu_id"));
                student.setStu_name(rs.getString("stu_name"));
                student.setStu_sex(rs.getString("stu_sex"));
                student.setStu_birth(rs.getString("stu_birth"));
                student.setStu_college(rs.getString("stu_college"));
                student.setStu_collegename(rs.getString("college_name"));
                student.setIntime(rs.getString("intime"));
                student.setStu_class(rs.getString("stu_class"));
                student.setStu_state(rs.getString("stu_state"));
                student.setStu_statename(rs.getString("state_name"));
                student.setStu_subject(rs.getString("stu_subject"));
                student.setStu_subjectname(rs.getString("sub_name"));
                student.setSanhao(rs.getString("sanhao"));
                return student;
            }
        }, stu_id);
    }

    //对学生表全部查找
    public List<Student> selectAll() {
        String sql = "select * from student_infor,college_infor,subject_infor,state where student_infor.stu_college=college_infor.college_id and student_infor.stu_subject=subject_infor.sub_id and student_infor.stu_state = state.state_id and student_infor.stu_state='1'";
        List<Student> studentList = new ArrayList<>();
        studentList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Student>>() {
            @Override
            public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Student> studentList1 = new ArrayList<>();
                while (rs.next()) {
                    Student student = new Student();
                    student.setStu_id(rs.getString("stu_id"));
                    student.setStu_name(rs.getString("stu_name"));
                    student.setStu_sex(rs.getString("stu_sex"));
                    student.setStu_birth(rs.getString("stu_birth"));
                    student.setStu_collegename(rs.getString("college_name"));
                    student.setIntime(rs.getString("intime"));
                    student.setStu_class(rs.getString("stu_class"));
                    student.setStu_state(rs.getString("stu_state"));
                    student.setStu_statename(rs.getString("state_name"));
                    student.setStu_subject(rs.getString("stu_subject"));
                    student.setStu_subjectname(rs.getString("sub_name"));
                    student.setStu_college(rs.getString("stu_college"));
                    student.setSanhao(rs.getString("sanhao"));
                    studentList1.add(student);
                }
                return studentList1;
            }
        });
        return studentList;
    }

    //对学生表进行添加操作
    public int addStudent(String stu_id,
                          String stu_name,
                          String stu_sex,
                          String stu_birth,
                          String stu_college,
                          String stu_subject,
                          String stu_class,
                          String intime,
                          String stu_state,
                          String sanhao) {
        String sql = "insert into student_infor values (?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{stu_id, stu_name, stu_sex, stu_birth, stu_college, stu_subject, stu_class, stu_state, intime, sanhao});
    }

    //对学生表按照stu_id进行修改
    public int stuUpdateByid(String stu_id,
                             String stu_name,
                             String stu_sex,
                             String stu_birth,
                             String stu_college,
                             String stu_subject,
                             String stu_class,
                             String intime,
                             String stu_state) {
        String sql = "update student_infor set stu_name=?,stu_sex=?,stu_birth=?,stu_college=?,stu_subject=?,stu_class=?,stu_state=?,intime=? where stu_id=?";
        return jdbcTemplate.update(sql, new Object[]{stu_name, stu_sex, stu_birth, stu_college, stu_subject, stu_class, stu_state, intime, stu_id});
    }

    //对学生表按照stu_id进行删除操作
    public int delete(String stu_id) {
        String sql = "delete from student_infor where stu_id=?";
        return jdbcTemplate.update(sql, new Object[]{stu_id});
    }

    //退学，结业，毕业处理
    public int updatestate(String stu_id, String stu_state) {
        String sql = "update student_infor set stu_state=? where stu_id=?";
        return jdbcTemplate.update(sql,new Object[]{stu_state,stu_id});
    }

    //三好学生处理
    public int updatesanhao(String stu_id, String sanhao) {
        String sql = "update student_infor set sanhao=? where stu_id=?";
        return jdbcTemplate.update(sql,new Object[]{sanhao,stu_id});
    }

    //查找退学，结业，毕业学生
    public List<Student> selectBystate(String stu_state){
        String sql = "select * from student_infor,college_infor,subject_infor where student_infor.stu_college=college_infor.college_id and student_infor.stu_subject=subject_infor.sub_id and student_infor.stu_state=?";
        List<Student> studentList = new ArrayList<>();
        studentList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Student>>() {
            @Override
            public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Student> studentList1 = new ArrayList<>();
                while (rs.next()) {
                    Student student = new Student();
                    student.setStu_id(rs.getString("stu_id"));
                    student.setStu_name(rs.getString("stu_name"));
                    student.setStu_sex(rs.getString("stu_sex"));
                    student.setStu_birth(rs.getString("stu_birth"));
                    student.setStu_collegename(rs.getString("college_name"));
                    student.setIntime(rs.getString("intime"));
                    student.setStu_class(rs.getString("stu_class"));
                    student.setStu_subject(rs.getString("stu_subject"));
                    student.setStu_subjectname(rs.getString("sub_name"));
                    student.setStu_college(rs.getString("stu_college"));
                    student.setSanhao(rs.getString("sanhao"));
                    studentList1.add(student);
                }
                return studentList1;
            }
        },stu_state);
        return studentList;
    }

    //查找三好学生
    public List<Student> selectBysanhao(){
        String sql = "select * from student_infor,college_infor,subject_infor where student_infor.stu_college=college_infor.college_id and student_infor.stu_subject=subject_infor.sub_id and student_infor.stu_state='1' and student_infor.sanhao='是'";
        List<Student> studentList = new ArrayList<>();
        studentList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Student>>() {
            @Override
            public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Student> studentList1 = new ArrayList<>();
                while (rs.next()) {
                    Student student = new Student();
                    student.setStu_id(rs.getString("stu_id"));
                    student.setStu_name(rs.getString("stu_name"));
                    student.setStu_sex(rs.getString("stu_sex"));
                    student.setStu_birth(rs.getString("stu_birth"));
                    student.setStu_collegename(rs.getString("college_name"));
                    student.setIntime(rs.getString("intime"));
                    student.setStu_class(rs.getString("stu_class"));
                    student.setStu_subject(rs.getString("stu_subject"));
                    student.setStu_subjectname(rs.getString("sub_name"));
                    student.setStu_college(rs.getString("stu_college"));
                    student.setSanhao(rs.getString("sanhao"));
                    studentList1.add(student);
                }
                return studentList1;
            }
        });
        return studentList;
    }

}
