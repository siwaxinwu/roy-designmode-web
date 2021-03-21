package com.roy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 基础电商推广服务
 *
 * @author dingyawu
 * @version 1.0
 * @date created in 22:28 2021-02-02
 */
public abstract class NetMall {
  protected Logger logger = LoggerFactory.getLogger(NetMall.class);
  String uId;
  String uPwd;

  public NetMall(String uId, String uPwd) {
    this.uId = uId;
    this.uPwd = uPwd;
  }

  public NetMall() {}

  /**
   * 生成商品推广海报
   *
   * @param skuUrl sku url
   * @return {@link String}
   */
  public String generateGoodsPoster(String skuUrl) {
    if (!login(uId, uPwd)) {
      return null;
    }
    Map<String, String> reptile = reptile(skuUrl);
    return createBase64(reptile);
  }

  /**
   * 模拟登陆
   *
   * @param uId 你的id
   * @param uPwd u pwd
   * @return {@link Boolean}
   */
  protected abstract Boolean login(String uId, String uPwd);

  /**
   * 爬虫获取商品信息
   *
   * @param skuUrl sku url
   * @return {@link Map<String, String>}
   */
  protected abstract Map<String, String> reptile(String skuUrl);

  /**
   * 生成商品海报信息
   *
   * @param goodsInfo 货物信息
   * @return {@link String}
   */
  protected abstract String createBase64(Map<String, String> goodsInfo);
}
