package com.roy.utils;

import com.roy.entity.Result;
import com.roy.entity.UserInfo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 14:36 2021-03-19
 */
public class LoginHelper {

  /**
   * 检查用户状态
   *
   * @param userInfo
   * @return
   */
  public static Result checkUserStatus(UserInfo userInfo) {
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

  /**
   * 登录失败
   *
   * @param userInfo
   */
  public static UserInfo loginFail(UserInfo userInfo) {
    // 验证码错误后，累计登录错误次数
    userInfo.setFailNumber(userInfo.getFailNumber() + 1);
    // 检查登录错误次数是否超过5次，超过则锁定账户30分钟。
    if (userInfo.getFailNumber() > 5) {
      // todo 以后引入自己的共用jar包
      // Date lockTime = DateUtils.addMinutes(new Date(), 30);
      // userInfo.setLockEndTime(lockTime);
    }
    return userInfo;
  }
}
