package com.roy.service.chain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 封装处理器权重
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-04-04 9:37
 */
@Getter
@AllArgsConstructor
public enum OrderHandlerWeightEnum {

    /**
     * 封装处理器权重
     */
    COUPON(1, "优惠券"),
    SALES(2, "促销活动"),
    VIP(3, "VIP"),;
    private final Integer code;
    private final String desc;
}
