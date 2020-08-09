package com.lijiaqing.studentmanage.dao;


import com.lijiaqing.studentmanage.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //对subject_infor（专业信息表）按照college_id进行查找
    public Subject selectByid(String college_id) {
        RowMapper<Subject> rowMapper = new BeanPropertyRowMapper<>(Subject.class);
        String sql = "select * from subject_infor where sub_college=?";
        return jdbcTemplate.queryForObject(sql,rowMapper,college_id);
    }

    //全部查找
    public List<Subject> selectAll(){
        RowMapper<Subject> subjectRowMapper = new BeanPropertyRowMapper<>(Subject.class);
        String sql="select * from subject_infor";
        return jdbcTemplate.query(sql,subjectRowMapper);
    }
}
