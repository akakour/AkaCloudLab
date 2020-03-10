package com.akakour.lab.feign.service;

import com.akakour.lab.feign.api.service.OrderService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "FEIGN-ORDER")
public interface ProductService extends OrderService {

}
