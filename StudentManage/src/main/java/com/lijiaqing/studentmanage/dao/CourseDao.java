package com.lijiaqing.studentmanage.dao;


import com.lijiaqing.studentmanage.entity.Course;
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
public class CourseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //按照教师的职工号进行查找
    public List<Course> selectByteaid(String tea_id) {
        String sql = "select * from course_infor where cou_teacher=?";
        RowMapper<Course> rowMapper = new BeanPropertyRowMapper<>(Course.class);
        return jdbcTemplate.query(sql, rowMapper, tea_id);
    }

    //按照课程号查找课程信息
    public Course selectById(String cou_id) {
        RowMapper<Course> rowMapper = new BeanPropertyRowMapper<>(Course.class);
        String sql = "select * from course_infor,teacher_infor,college_infor where cou_id=? and course_infor.cou_college=college_infor.college_id and course_infor.cou_teacher=teacher_infor.tea_id";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Course>() {
            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                Course course = new Course();
                course.setCou_id(rs.getString("cou_id"));
                course.setCou_name(rs.getString("cou_name"));
                course.setCou_college(rs.getString("cou_college"));
                course.setCou_collegename(rs.getString("college_name"));
                course.setCou_credit(rs.getFloat("cou_credit"));
                course.setCou_teacher(rs.getString("cou_teacher"));
                course.setCou_teachername(rs.getString("tea_name"));
                return course;
            }
        },cou_id);
    }

    //对课程表进行全部查找
    public List<Course> selectAll() {
        String sql = "select * from course_infor,teacher_infor,college_infor where course_infor.cou_college=college_infor.college_id and course_infor.cou_teacher=teacher_infor.tea_id";
        List<Course> courseList = new ArrayList<>();
        courseList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Course>>() {
            @Override
            public List<Course> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Course> courseList1 = new ArrayList<>();
                while(rs.next()){
                    Course course = new Course();
                    course.setCou_id(rs.getString("cou_id"));
                    course.setCou_name(rs.getString("cou_name"));
                    course.setCou_credit(rs.getFloat("cou_credit"));
                    course.setCou_college(rs.getString("cou_college"));
                    course.setCou_collegename(rs.getString("college_name"));
                    course.setCou_teacher(rs.getString("cou_teacher"));
                    course.setCou_teachername(rs.getString("tea_name"));
                    courseList1.add(course);
                }
                return courseList1;
            }
        });
        return courseList;
    }

    //对课程表进行增加操作
    public int addCourse(String cou_id,
                         String cou_name,
                         String cou_college,
                         float cou_credit,
                         String cou_teacher) {
        String sql = "insert into course_infor values (?,?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{cou_id, cou_name, cou_college, cou_credit, cou_teacher});
    }

    //对课程表按id进行修改
    public int updateByid(String cou_id,
                          String cou_name,
                          String cou_college,
                          float cou_credit,
                          String cou_teacher) {
        String sql = "update course_infor set cou_name=?,cou_college=?,cou_credit=?,cou_teacher=? where cou_id=?";
        return jdbcTemplate.update(sql, new Object[]{cou_name, cou_college, cou_credit, cou_teacher, cou_id});
    }

    //对课程表按ID进行删除
    public int deleteByid(String cou_id) {
        String sql = "delete from course_infor where cou_id=?";
        return jdbcTemplate.update(sql, new Object[]{cou_id});
    }
}
