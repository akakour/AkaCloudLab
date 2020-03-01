package com.akakour.lab.eurekaclient.commodity.controller;

import com.akakour.lab.eurekaclient.commodity.dto.CommodityBean;
import com.akakour.lab.eurekaclient.commodity.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/commodity")
@RestController
public class CommodityController {

    @Autowired
    OrderServiceImpl orderService;

    @RequestMapping("/test")
    public CommodityBean test() {

        CommodityBean commodityBean = new CommodityBean();
        return orderService.addToOrder(commodityBean);
    }
}
