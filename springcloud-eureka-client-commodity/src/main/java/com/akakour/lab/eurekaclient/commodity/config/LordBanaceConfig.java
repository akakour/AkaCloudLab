package com.akakour.lab.eurekaclient.commodity.config;

import com.akakour.lab.eurekaclient.rabbin.RabbinConfig;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RibbonClients(value = {
        @RibbonClient(name = "micro-order", configuration = RabbinConfig.class)
})
public class LordBanaceConfig {

    @Bean
    //负载均衡注解
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
