package com.roy.controller;

import com.roy.entity.PromoteDTO;
import com.roy.service.NetMall;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 22:41 2021-02-02
 */
@RestController
@RequestMapping("/promote")
public class TemplateController {

  private static Map<String, NetMall> map = new HashMap<>();

  @PostMapping("/site")
  public String promote(@RequestBody @Validated PromoteDTO promoteDTO) {
    NetMall netMall = map.get(promoteDTO.getType());
    if (null == netMall) {
      throw new RuntimeException("type传参不合法");
    }
    return netMall.generateGoodsPoster(promoteDTO.getUrl());
  }
}
