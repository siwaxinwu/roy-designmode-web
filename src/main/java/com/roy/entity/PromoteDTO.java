package com.roy.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 推广请求实体
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 22:44 2021-02-02
 */
@Data
public class PromoteDTO {
  /** 网站类型 */
  @NotNull(message = "网站类型不能为空")
  private String type;

  /** 用户id */
  @NotNull(message = "用户id不能为空")
  private String uid;

  /** 用户密码 */
  private String uPwd;

  /** 爬虫url */
  private String url;
}
