package com.roy.service;

import com.roy.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 14:34 2021-03-19
 */
public interface LoginService {

  /** 缓存登录方式和处理策略对象的关系 */
  @Autowired Map<String, LoginService> loginServerMap = new HashMap();

  /**
   * 登录
   *
   * @param userName 用户名
   * @param password 密码
   * @return {@link Result}
   */
  Result login(String userName, String password);
}
