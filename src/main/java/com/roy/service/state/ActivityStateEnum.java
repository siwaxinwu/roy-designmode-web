package com.roy.service.state;

import lombok.Getter;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-05 10:03
 */
@Getter
public enum ActivityStateEnum {

  /** 运营活动状态 */
  DRAFT(1, "草稿箱"),
  ENABLE(2, "已启用"),
  START(3, "进行中"),
  DISABLE(4, "已停用"),
  FINISH(5, "已结束");

  private Integer code;
  private String desc;

  ActivityStateEnum(Integer code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
