package com.lijiaqing.studentmanage.dao;


import com.lijiaqing.studentmanage.entity.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LoginDao {

    @Autowired
    private JdbcTemplate JdbcTemplate;

    /*登录功能，如果查到数据库有数据则为true，否则为false
     * 对login_user表根据userid和password进行查找
     */
    public LoginUser Select(String userid, String password) {
        RowMapper<LoginUser> rowMapper = new BeanPropertyRowMapper<LoginUser>(LoginUser.class);//设置返回数据类型
        String sql = "select * from login_user where userid=? and password=?";
        LoginUser loginuser = new LoginUser();//创建一个空对象
        try {
            LoginUser loginUser = JdbcTemplate.queryForObject(sql, rowMapper, userid, password);
            if (!loginUser.toString().isEmpty()) {
                return loginUser;
            }
        } catch (EmptyResultDataAccessException e) { //抓捕空数据异常
            return loginuser;
        }
        return loginuser;
    }


    // 用userID进行查找
    public LoginUser Selectbyid(String userid) {
        String sql = "select * from login_user where userid=?";
        return JdbcTemplate.queryForObject(sql, new RowMapper<LoginUser>() {
            @Override
            public LoginUser mapRow(ResultSet resultSet, int i) throws SQLException {
                LoginUser loginUser = new LoginUser();
                loginUser.setUserid(resultSet.getString("userid"));
                loginUser.setPassword(resultSet.getString("password"));
                loginUser.setRealname(resultSet.getString("realname"));
                loginUser.setRole(resultSet.getString("role"));
                return loginUser;
            }
        }, userid);
    }

    //对login_user表进行全部查找
    public List<LoginUser> selectAll() {
        String sql = "select * from login_user";
        RowMapper<LoginUser> rowMapper = new BeanPropertyRowMapper<>(LoginUser.class);//设置返回数据类型
        return JdbcTemplate.query(sql, rowMapper);
    }

    //对登录用户表进行修改，即修改密码
    public int updataPwd(String userid, String newpassword) {
        String sql = "update login_user set password=? where userid=?";
        return JdbcTemplate.update(sql, new Object[]{newpassword, userid});
    }

    //对login_user表进行增加
    public int addLoginuser(String userid, String password, String role, String realname) {
        String sql = "insert into login_user(userid,password,role,realname) values(?,?,?,?)";
        return JdbcTemplate.update(sql, new Object[]{userid, password, role, realname});
    }

    //对login_user表按userid进行删除操作
    public int deleteByid(String userid) {
        String sql = "delete from login_user where userid=?";
        return JdbcTemplate.update(sql, new Object[]{userid});
    }
}