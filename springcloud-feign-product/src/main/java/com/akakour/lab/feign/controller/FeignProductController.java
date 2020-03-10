package com.akakour.lab.feign.controller;


import com.akakour.lab.feign.api.bean.ResultBean;
import com.akakour.lab.feign.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/product/feign")
public class FeignProductController {
    @Autowired
    private ProductService productService;

    public ResultBean get
}
