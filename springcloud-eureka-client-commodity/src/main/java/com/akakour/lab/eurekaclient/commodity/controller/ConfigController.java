package com.akakour.lab.eurekaclient.commodity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RefreshScope 配合@value使用才能及时刷新配置
@RefreshScope
@Slf4j
@RequestMapping("/commodity")
public class ConfigController {
    @Value("${redis.password:1211212}")
    private String redispw;

    @Autowired
    Environment env;

    @RequestMapping("/config")
    public String config() {
        log.info("实例code"+this.hashCode());
        log.info("----springcloud-config： 【@Value redis.password】：" + redispw);
        log.info("----springcloud-config： 【Environment redis.password】：" +
                env.getProperty("redis.password"));
        return "success";
    }
}
