package com.roy.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 14:32 2021-03-19
 */
@Data
public class UserInfo {
  // 用户名
  private String userName;

  // 密码
  private String password;

  // 手机号码
  private String phone;

  // 账户状态
  private int status;

  // 锁定结束时间
  private Date lockEndTime;

  // 登录失败次数
  private int failNumber;

  // 手势
  private String guesture;
}
