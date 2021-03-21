package com.roy.service.impl.login;

import com.roy.dao.UserDao;
import com.roy.entity.Result;
import com.roy.entity.UserInfo;
import com.roy.service.AbstractLogin;
import com.roy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 验证码登录实现
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 14:40 2021-03-19
 */
@Service("smsLoginService")
public class SMSLoginService extends AbstractLogin {

  @Autowired private UserDao userDao;

  @Autowired
  public SMSLoginService(UserDao userDao) {
    super(userDao);
    LoginService.loginServerMap.put("2", this);
  }

  @Override
  public Result doLogin(UserInfo userInfo, String smsCode) {
    // 验证码是否正确
    String code = userDao.querySmsCode(userInfo.getUserName());
    if (!code.equals(smsCode)) {
      return new Result("004", "验证码错误", null);
    } else {
      return new Result("200", "登录成功", null);
    }
  }
}
