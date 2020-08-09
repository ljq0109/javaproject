package com.lijiaqing.studentmanage.service;

import com.lijiaqing.studentmanage.entity.LoginUser;

import java.util.List;

public interface LoginService {

    //登录接口  按userid和password查找
    LoginUser Select(String userid, String password);


    //按照ID查询
    LoginUser Selectbyid(String userid);

    //修改用户密码接口   按userid进行修改
    int updataPwd(String userid,String newpassword);


    //对login_user表进行全部查找
    List<LoginUser> selectAll();


    //对login_user表进行增加
    int addLoginuser(String userid, String password, String role, String realname);


    //对login_user表按userid进行删除操作
    int deleteByid(String userid);
}
