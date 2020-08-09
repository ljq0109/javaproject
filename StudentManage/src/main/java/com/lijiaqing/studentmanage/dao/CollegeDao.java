package com.lijiaqing.studentmanage.dao;


import com.lijiaqing.studentmanage.entity.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CollegeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //对college_infor表按照college_id进行查找
    public College selectByid(String college_id){
        String sql="select * from college_infor where college_id=?";
        RowMapper<College> rowMapper=new BeanPropertyRowMapper<>(College.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,college_id);
    }

    //对college_infor表进行全部查找
    public List<College> selectAll(){
        String sql = "select * from college_infor";
        RowMapper<College> collegeRowMapper = new BeanPropertyRowMapper<>(College.class);
        return jdbcTemplate.query(sql,collegeRowMapper);
    }
}
