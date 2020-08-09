package com.lijiaqing.studentmanage.dao;

import com.lijiaqing.studentmanage.entity.Teacher;
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
public class TeacherDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //对教师表进行全部查找操作
    public List<Teacher> selectAll() {
        String sql = "select * from teacher_infor,college_infor where college_infor.college_id = teacher_infor.tea_college";
        List<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Teacher>>() {
            @Override
            public List<Teacher> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Teacher> teacherList1 = new ArrayList<Teacher>();
                while (rs.next()) {
                    Teacher teacher = new Teacher();
                    teacher.setTea_id(rs.getString("tea_id"));
                    teacher.setTea_name(rs.getString("tea_name"));
                    teacher.setCol_name(rs.getString("college_name"));
                    teacher.setTea_sex(rs.getString("tea_sex"));
                    teacher.setTea_college(rs.getString("tea_college"));
                    teacherList1.add(teacher);
                }
                return teacherList1;
            }
        });
           return teacherList;
    }

    //对教师表按照id进行查找
    public Teacher selectByid(String tea_id) {
        String sql = "select * from teacher_infor,college_infor where tea_id=? and college_id = tea_college";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Teacher>() {
            @Override
            public Teacher mapRow(ResultSet resultSet, int i) throws SQLException {
                Teacher teacher = new Teacher();
                teacher.setTea_id(resultSet.getString("tea_id"));
                teacher.setTea_name(resultSet.getString("tea_name"));
                teacher.setCol_name(resultSet.getString("college_name"));
                teacher.setTea_sex(resultSet.getString("tea_sex"));
                teacher.setTea_college(resultSet.getString("tea_college"));
                return teacher;
            }
        }, tea_id);
    }


    //对教师表进行增加操作
    public int addTeacher(String tea_id,
                          String tea_name,
                          String tea_sex,
                          String tea_college) {
        String sql = "insert into teacher_infor values(?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{tea_id, tea_name, tea_sex, tea_college});
    }

    //对教师表按id进行删除操作
    public int deleteByid(String tea_id) {
        String sql = "delete from teacher_infor where tea_id=?";
        return jdbcTemplate.update(sql, new Object[]{tea_id});
    }

    //对教师表按照id进行修改
    public int updateByid(String tea_id,
                          String tea_name,
                          String tea_sex,
                          String tea_college) {
        String sql = "update teacher_infor set tea_name=?,tea_sex=?,tea_college=? where tea_id=?";
        return jdbcTemplate.update(sql, new Object[]{tea_name, tea_sex, tea_college, tea_id});
    }
}
