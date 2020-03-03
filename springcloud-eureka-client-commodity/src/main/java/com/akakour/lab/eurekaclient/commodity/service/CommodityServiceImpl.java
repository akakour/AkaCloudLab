package com.akakour.lab.eurekaclient.commodity.service;

import com.akakour.lab.eurekaclient.commodity.api.CommodityService;
import com.akakour.lab.eurekaclient.commodity.dto.CommodityBean;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
//@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class CommodityServiceImpl implements CommodityService {

    public static String SERVIER_NAME = "client-order";

    @Autowired
    private RestTemplate restTemplate;


    @Override
    @HystrixCommand(
            fallbackMethod = "hytrixFallbackMethod",
            commandKey = "addToOrder:commandLey",
            groupKey = "addToOrder:groupKey",
            commandProperties = {
                    //默认 线程池 策略
                    @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
                    //单条线程调用超时时间，超时以后走fallbackMethod处理，可以做retry，或者直接降级
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")
            },
            //线程池 key，hystrix的线程池策略会自己新开一个线程池（可以与其他HystrixCommand共用）来对应用户请求线程，所以这是一种牺牲空间换时间的策略
            threadPoolKey = "addToOrder:threadPoolKey",
            threadPoolProperties = {
                    //设置线程池大小
                    @HystrixProperty(name = "coreSize", value = "100")
            }
    )
    public CommodityBean addToOrderByThread(CommodityBean commodityBean) {
        log.info("addToOrderByThread:threadName(线程池) --> " + Thread.currentThread().getName());
        //get 这个会选择一个服务列表调用
        return restTemplate.getForObject("http://"
                + SERVIER_NAME + "/order/addToOrder", CommodityBean.class);
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "hytrixFallbackMethod",
            commandKey = "addToOrder:commandLey",
            groupKey = "addToOrder:groupKey",
            commandProperties = {
                    //信号量 策略
                    @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
                    //信号量大小，超过可以或者直接降级
                    @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests", value = "100")
            }
    )
    public CommodityBean addToOrderBySemaphroe(CommodityBean commodityBean) {
        log.info("addToOrderBySemaphroe:threadName(信号量) --> " + Thread.currentThread().getName());
        //get 这个会选择一个服务列表调用
        return restTemplate.getForObject("http://"
                + SERVIER_NAME + "/order/addToOrder", CommodityBean.class);
    }

    /**
     * Hytrix fallbackmethod
     *
     * @param commodityBean
     * @return
     */
    private CommodityBean hytrixFallbackMethod(CommodityBean commodityBean) {

        log.error("接口请求失败，降级处理。。。。。。" +
                "hytrixFallbackMethod:thread.getName() --> " + Thread.currentThread().getName());
        commodityBean.setCreated(false);
        commodityBean.setCommodityId(null);
        return commodityBean;
    }
}
