package com.akakour.lab.eurekaclient.commodity.controller;

import com.akakour.lab.eurekaclient.commodity.dto.CommodityBean;
import com.akakour.lab.eurekaclient.commodity.service.CommodityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/commodity")
@RestController
public class CommodityController {

    @Autowired
    CommodityServiceImpl orderService;

    @RequestMapping("/Thread")
    public CommodityBean hystrixByThread() {

        CommodityBean commodityBean = new CommodityBean();
        return orderService.addToOrderByThread(commodityBean);
    }

    @RequestMapping("/Semaphore")
    public CommodityBean hystrixBySemaphore() {

        CommodityBean commodityBean = new CommodityBean();
        return orderService.addToOrderBySemaphroe(commodityBean);
    }
}
