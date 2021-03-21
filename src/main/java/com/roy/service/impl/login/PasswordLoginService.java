package com.roy.service.impl.login;

import com.roy.dao.UserDao;
import com.roy.entity.Result;
import com.roy.entity.UserInfo;
import com.roy.service.AbstractLogin;
import com.roy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 密码登录实现
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 14:39 2021-03-19
 */
@Service("passwordLoinService")
public class PasswordLoginService extends AbstractLogin {

  @Autowired
  public PasswordLoginService(UserDao userDao) {
    super(userDao);
    LoginService.loginServerMap.put("1", this);
  }

  @Override
  public Result doLogin(UserInfo userInfo, String password) {
    // 验证密码是否正确
    if (!userInfo.getPassword().equals(password)) {
      return new Result("004", "账户名或密码错误", null);
    } else {
      return new Result("200", "登录成功", null);
    }
  }
}
