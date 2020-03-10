package com.akakour.lab.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
//开启断路器功能
@EnableCircuitBreaker
//开启Feign功能，指定client映射关系
@EnableFeignClients(clients = {})
public class FeignProduct {
    public static void main(String[] args) {
        SpringApplication.run(FeignProduct.class, args);
    }
}
