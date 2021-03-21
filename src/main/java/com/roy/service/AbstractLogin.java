package com.roy.service;

import com.roy.dao.UserDao;
import com.roy.entity.Result;
import com.roy.entity.UserInfo;
import com.roy.utils.DateUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 14:43 2021-03-19
 */
public abstract class AbstractLogin implements LoginService {

  private UserDao userDao;

  public AbstractLogin(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public Result login(String userName, String content) {
    // 查询用户信息
    UserInfo userInfo = userDao.queryByUserName(userName);
    // 检查用户状态
    Result result = checkUserStatus(userInfo);
    if (result != null) {
      return result;
    }
    // 登录验证
    result = doLogin(userInfo, content);
    // 登录失败
    if (!result.getCode().equals("200")) {
      loginFail(userInfo);
      return result;
    }
    // 登录成功
    result = loginSuccess(userInfo);
    return result;
  }

  /**
   * 登录验证
   *
   * @param userInfo
   * @return
   */
  public abstract Result doLogin(UserInfo userInfo, String content);

  /**
   * 检查用户状态
   *
   * @param userInfo
   * @return
   */
  private Result checkUserStatus(UserInfo userInfo) {
    if (userInfo == null) {
      return new Result("001", "用户不存在", null);
    }
    // 检查用户是否被禁用了(0正常，1禁用)
    if (userInfo.getStatus() == 1) {
      return new Result("002", "账号已被禁用", null);
    }
    // 检查用户是否被锁定了。
    Date lockEndTime = userInfo.getLockEndTime();
    if (lockEndTime != null && lockEndTime.getTime() > System.currentTimeMillis()) {
      return new Result("003", "账户已锁定", null);
    }
    return null;
  }

  /**
   * 登录失败
   *
   * @param userInfo
   */
  public void loginFail(UserInfo userInfo) {
    // 验证码错误后，累计登录错误次数
    userInfo.setFailNumber(userInfo.getFailNumber() + 1);
    // 检查登录错误次数是否超过5次，超过则锁定账户30分钟。
    if (userInfo.getFailNumber() > 5) {
      Date lockTime = DateUtils.addMinutes(new Date(), 30);
      userInfo.setLockEndTime(lockTime);
    }
    userDao.update(userInfo);
  }

  /**
   * 登录成功
   *
   * @param userInfo
   * @return
   */
  public static Result loginSuccess(UserInfo userInfo) {
    Map map = new HashMap<>();
    map.put("userInfo", userInfo);
    map.put("token", "生成的token信息");
    return new Result("200", "成功", map);
  }
}
