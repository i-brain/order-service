package com.ibrahim.order_service.service;

import com.ibrahim.order_service.client.UserServiceClient;
import com.ibrahim.order_service.model.Order;
import com.ibrahim.order_service.model.OrderRequest;
import com.ibrahim.order_service.model.User;
import com.ibrahim.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;
    private final UserServiceClient userServiceClient;


    public Order createOrder(OrderRequest orderRequest){
        User user = userServiceClient.getUserById(orderRequest.getUserId());
        Order order = new Order();
        order.setUserId(orderRequest.getUserId());
        order.setUsername(user.getUsername());
         return repository.save(order);
    }

    @Cacheable("orders")
    public List<Order> getOrders(){
        return repository.findAll();
    }
}
