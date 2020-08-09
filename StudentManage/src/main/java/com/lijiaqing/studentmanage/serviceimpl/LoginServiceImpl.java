package com.lijiaqing.studentmanage.serviceimpl;


import com.lijiaqing.studentmanage.dao.LoginDao;
import com.lijiaqing.studentmanage.entity.LoginUser;
import com.lijiaqing.studentmanage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    //登录的实现    按userid和password查找
    @Override
    public LoginUser Select(String userid, String password) {
        return loginDao.Select(userid, password);
    }

    //按userid查找
    @Override
    public LoginUser Selectbyid(String userid) {
        return loginDao.Selectbyid(userid);
    }

    //修改用户密码  按userid进行修改
    @Override
    public int updataPwd(String userid, String newpassword) {
        return loginDao.updataPwd(userid, newpassword);
    }

    @Override
    public List<LoginUser> selectAll() {
        return loginDao.selectAll();
    }

    @Override
    public int addLoginuser(String userid, String password, String role, String realname) {
        return loginDao.addLoginuser(userid, password, role, realname);
    }

    @Override
    public int deleteByid(String userid) {
        return loginDao.deleteByid(userid);
    }
}
