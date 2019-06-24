package com.hm.hdm.service;

import com.hm.hdm.entity.User;

/**
 * @program: hospital-manager
 * @Date: 2019/6/24 16:36
 * @Author: Mr.Han
 * @Description:
 */
public interface UserService {


 /**
  * 通过用户名和密码登录
  * @param name
  * @param password
  * @return
  */
 User login(String name, String password);

}
