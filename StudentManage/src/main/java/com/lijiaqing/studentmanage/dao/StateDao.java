package com.lijiaqing.studentmanage.dao;


import com.lijiaqing.studentmanage.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class StateDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    //全部查找
    public List<State> selectAll(){
        RowMapper<State> stateRowMapper = new BeanPropertyRowMapper<>(State.class);
        String sql="select * from state";
        return jdbcTemplate.query(sql,stateRowMapper);
    }
}
