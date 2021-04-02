package com.roy.service.handler;

import org.springframework.stereotype.Component;

@Component
public class KangBaHandler2 extends AbstractHandler {

  @Override
  public void AAA(String name) {
    // 业务逻辑A
    System.out.println("亢八完成任务");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    Factory2.register("亢八", this);
  }
}
