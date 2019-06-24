package com.hm.hdm.dao;

import com.hm.hdm.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @program: hospital-manager
 * @Date: 2019/6/24 16:22
 * @Author: Mr.Han
 * @Description:
 */
@Repository("userDao")
public interface UserDao {

 /**
  * 通过userName查询用户
  *
  * @param userName
  * @return
  */
 User findByUserName(String userName);

}
