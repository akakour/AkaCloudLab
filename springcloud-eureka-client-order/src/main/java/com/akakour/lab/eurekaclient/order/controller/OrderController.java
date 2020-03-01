package com.akakour.lab.eurekaclient.order.controller;

import com.akakour.lab.eurekaclient.order.dto.CommodityBean;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
@Slf4j
public class OrderController {

    private static final Logger loger = LoggerFactory.getLogger(OrderController.class);

    @RequestMapping("/addToOrder")
    public CommodityBean test(CommodityBean commodityBean) {

        loger.info("========== call this ===================");
        commodityBean.setCreated(true);
        return commodityBean;
    }
}
