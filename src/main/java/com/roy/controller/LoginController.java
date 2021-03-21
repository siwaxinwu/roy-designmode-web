package com.roy.controller;

import com.roy.entity.Result;
import com.roy.service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 14:30 2021-03-19
 */
@RestController
@RequestMapping("/user")
public class LoginController {

  @GetMapping(value = "/login")
  public Result login(String username, String content, String loginType) {
    // 根据登录类型，获取对应登录策略处理对象
    LoginService loginService = LoginService.loginServerMap.get(loginType);
    System.out.println(loginService);
    Result result = loginService.login(username, content);
    return result;
  }
}
