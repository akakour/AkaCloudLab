package com.akakour.lab.eurekaclient.commodity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
//开启eureka客户端功能
@EnableEurekaClient
//开启Hystrix 断路器
@EnableCircuitBreaker
public class EurekaClientCommodity {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientCommodity.class, args);
    }

}
