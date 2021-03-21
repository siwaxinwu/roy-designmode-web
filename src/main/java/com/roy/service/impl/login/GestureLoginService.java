package com.roy.service.impl.login;

import com.roy.dao.UserDao;
import com.roy.entity.Result;
import com.roy.entity.UserInfo;
import com.roy.service.AbstractLogin;
import com.roy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 手势登录实现
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 14:36 2021-03-19
 */
@Service("gGestureLoginService")
public class GestureLoginService extends AbstractLogin {

  @Autowired
  public GestureLoginService(UserDao userDao) {
    super(userDao);
    LoginService.loginServerMap.put("3", this);
  }

  @Override
  public Result doLogin(UserInfo userInfo, String geture) {
    // 验手势密码是否正确
    if (!userInfo.getGuesture().equals(geture)) {
      return new Result("004", "手势密码错误", null);
    } else {
      return new Result("200", "登录成功", null);
    }
  }
}
