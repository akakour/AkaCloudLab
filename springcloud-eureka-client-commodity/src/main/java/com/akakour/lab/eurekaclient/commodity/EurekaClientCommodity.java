package com.akakour.lab.eurekaclient.commodity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//开启eureka客户端功能
@EnableEurekaClient
public class EurekaClientCommodity {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientCommodity.class, args);
    }

}
