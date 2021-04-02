package com.roy.controller;

import com.roy.service.handler.AbstractHandler;
import com.roy.service.handler.Factory2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 22:54 2021-04-02
 */
@RestController
public class TemplateAndStrategyAndFactoryController {
  @RequestMapping("/test")
  public String test(String name) {
    AbstractHandler handler = Factory2.getInvokeStrategy(name);
    return handler.BBB(name);
  }
}
