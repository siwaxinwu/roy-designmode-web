package com.roy.service.state;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-05 10:03
 */
@Data
@Accessors(chain = true)
public class Activity {
  private Long id;

  private String name;

  private Integer status;

  private LocalDateTime createTime;

  private LocalDateTime updateTime;
}
