package com.roy.entity;

import lombok.Data;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 14:31 2021-03-19
 */
@Data
public class Result {
  // 响应状态码
  private String code;

  // 响应状态消息
  private String message;
  // 响应内容
  private Object content;

  public Result(String code, String message, Object content) {
    this.code = code;
    this.message = message;
    this.content = content;
  }
}
