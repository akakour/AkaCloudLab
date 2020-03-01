package com.akakour.lab.eurekaclient.rabbin;

import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbinConfig {

    private String name = "client-order";

    @Bean
    @ConditionalOnClass
    public IClientConfig defaultClientConfigImpl() {
        DefaultClientConfigImpl config = new DefaultClientConfigImpl();
        config.loadProperties(name);
        config.set(CommonClientConfigKey.MaxAutoRetries,2);
        config.set(CommonClientConfigKey.MaxAutoRetriesNextServer,2);
        config.set(CommonClientConfigKey.ConnectTimeout,2000);
        config.set(CommonClientConfigKey.ReadTimeout,4000);
        config.set(CommonClientConfigKey.OkToRetryOnAllOperations,true);
        return config;
    }

    /*
     * 判断服务是否存活
     * 不建议使用
     * */
//    @Bean
    public IPing iPing() {
        //这个实现类会去调用服务来判断服务是否存活
        return new PingUrl();
    }

    @Bean
    public IRule ribbonRule() {
        //线性轮训
        new RoundRobinRule();
        //可以重试的轮训
        new RetryRule();
        //根据运行情况来计算权重
        new WeightedResponseTimeRule();
        //过滤掉故障实例，选择请求数最小的实例
        new BestAvailableRule();
        return new RandomRule();
    }
}
