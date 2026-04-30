package com.ibrahim.order_service.controller;

import com.ibrahim.order_service.model.Order;
import com.ibrahim.order_service.model.OrderRequest;
import com.ibrahim.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/orders")
public class OrderController {
    private final OrderService service;

    @GetMapping
    public List<Order> getOrders(){
        return service.getOrders();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody OrderRequest request){
        return service.createOrder(request);
    }

    @GetMapping("/test")
    public String test(){
        return "pong";
    }

}
