package com.roy.service.handler;

import org.springframework.stereotype.Component;

@Component
public class TianQiHandler2 extends AbstractHandler {

  @Override
  public void AAA(String name) {
    // 业务逻辑A
    System.out.println("田七完成任务A");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    Factory2.register("田七", this);
  }
}
