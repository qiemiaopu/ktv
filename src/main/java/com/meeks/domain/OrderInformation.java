package com.meeks.domain;

import java.util.Date;

/**
 * 商品交易
 */
public class OrderInformation {
    private Integer id;
    private Integer count;//交易数量
    private Date createTime;//交易时间
    private Double sumValues;//小计
    private Integer commodityId;//商品
    private Double cost;//小计

}
