package com.roy.service.handler;

import org.springframework.stereotype.Component;

@Component
public class WangWuHandler2 extends AbstractHandler {

  @Override
  public String BBB(String name) {
    // 业务逻辑B
    return "王五完成任务B";
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    Factory2.register("王五", this);
  }
}
