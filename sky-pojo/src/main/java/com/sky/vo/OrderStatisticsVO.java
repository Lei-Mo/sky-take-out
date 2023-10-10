package com.sky.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderStatisticsVO implements Serializable {
    // 待接单数量
    private Integer toBeConfirmed;

    // 待派送数量
    private Integer confirmed;

    // 派送中数量
    private Integer deliveryInProgress;

    public OrderStatisticsVO(Integer toBeConfirmed, Integer confirmed, Integer deliveryInProgress) {
        this.toBeConfirmed = toBeConfirmed;
        this.confirmed = confirmed;
        this.deliveryInProgress = deliveryInProgress;
    }
}
