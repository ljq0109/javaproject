package com.lijiaqing.studentmanage.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleTeacherDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //对表进行增加操作
    public int addTeacher(String tea_id, String tea_name) {
        String sql = "insert into teacher_infors values(?,?)";
        return jdbcTemplate.update(sql, new Object[]{tea_id, tea_name});
    }
}
