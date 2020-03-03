package com.akakour.lab.eurekaclient.commodity.api;

import com.akakour.lab.eurekaclient.commodity.dto.CommodityBean;

public interface CommodityService {
    CommodityBean addToOrderByThread(CommodityBean commodityBean);
    CommodityBean addToOrderBySemaphroe(CommodityBean commodityBean);
}
