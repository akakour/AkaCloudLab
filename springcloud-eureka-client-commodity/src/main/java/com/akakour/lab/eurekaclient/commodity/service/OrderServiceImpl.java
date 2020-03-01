package com.akakour.lab.eurekaclient.commodity.service;

import com.akakour.lab.eurekaclient.commodity.api.OrderService;
import com.akakour.lab.eurekaclient.commodity.dto.CommodityBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
//@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OrderServiceImpl implements OrderService {

    public static String SERVIER_NAME = "client-order";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CommodityBean addToOrder(CommodityBean commodityBean) {
        //get 这个会选择一个服务列表调用
        return restTemplate.getForObject("http://"
                + SERVIER_NAME + "/order/addToOrder", CommodityBean.class);
    }
}
