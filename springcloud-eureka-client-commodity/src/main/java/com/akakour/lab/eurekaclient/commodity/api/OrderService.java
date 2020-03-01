package com.akakour.lab.eurekaclient.commodity.api;

import com.akakour.lab.eurekaclient.commodity.dto.CommodityBean;

public interface OrderService {
    CommodityBean addToOrder(CommodityBean commodityBean);
}
