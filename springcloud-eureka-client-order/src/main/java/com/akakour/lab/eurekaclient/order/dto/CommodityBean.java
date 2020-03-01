package com.akakour.lab.eurekaclient.order.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommodityBean {
    Date createTime;
    Integer commodityId;
    Float price;
    Boolean created;
}
