package com.akakour.lab.feign.api.service;

import com.akakour.lab.feign.api.bean.ResultBean;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/feign/order")
public interface OrderService {

    @RequestMapping("/getOneOrderById")
    public ResultBean getOneOrderById(@RequestParam String id);

//    @RequestMapping("/getAllOrderById")
//    public List<ResultBean> getAllOrderById(@RequestPart("id") String id);

    @RequestMapping("/getOrder/{id}")
    public ResultBean getOrder(@PathVariable String id);

    @PostMapping("/saveOrder")
    public int saveOrder(@RequestBody ResultBean resultBean);
}
