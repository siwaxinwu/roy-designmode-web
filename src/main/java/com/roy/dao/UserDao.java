package com.roy.dao;

import com.roy.entity.UserInfo;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 14:42 2021-03-19
 */
@Component
public class UserDao {

  public UserInfo queryByUserName(String userName) {
    UserInfo userInfo = new UserInfo();
    userInfo.setUserName("roy");
    userInfo.setPassword("123456");
    userInfo.setPhone("15371452705");
    userInfo.setStatus(1);
    userInfo.setLockEndTime(new Date());
    userInfo.setFailNumber(1);
    return userInfo;
  };

  public int update(UserInfo userInfo) {
    return 1;
  }

  public String querySmsCode(String phone) {
    return "1234";
  }
}
