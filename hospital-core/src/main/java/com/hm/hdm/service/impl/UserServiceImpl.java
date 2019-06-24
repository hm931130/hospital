package com.hm.hdm.service.impl;

import com.hm.hdm.dao.UserDao;
import com.hm.hdm.entity.User;
import com.hm.hdm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: hospital-manager
 * @Date: 2019/6/24 16:37
 * @Author: Mr.Han
 * @Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {

 @Autowired
 private UserDao userDao;

 public User login(String name, String password) {
  User user = userDao.findByUserName(name);
  //存在用户且密码正确
  if (null != user && user.getPassWord().equals(password)) {
   return user;
  }
  return null;
 }
}
