package com.roy.service.handler;

import org.springframework.stereotype.Component;

@Component
public class ZhangSanHandler2 extends AbstractHandler {

  @Override
  public String BBB(String name) {
    // 业务逻辑B
    return "张三完成任务B";
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    Factory2.register("张三", this);
  }
}
