package com.roy.service.handler;

import org.springframework.stereotype.Component;

@Component
public class LiSiHandler2 extends AbstractHandler {

  @Override
  public String BBB(String name) {
    // 业务逻辑B
    return "李四完成任务B";
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    Factory2.register("李四", this);
  }
}
