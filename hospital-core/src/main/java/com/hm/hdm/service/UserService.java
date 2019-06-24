package com.hm.hdm.service;

import com.hm.hdm.entity.User;

/**
 * @program: hospital-manager
 * @Date: 2019/6/24 16:36
 * @Author: Mr.Han
 * @Description:
 */
public interface UserService {


 User login(String name, String password);

}
