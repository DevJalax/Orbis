package com.scm.Supply.chain.apis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.Entity.Order;
import com.scm.Supply.chain.apis.Entity.Product;
import com.scm.Supply.chain.apis.Exceptions.InvalidOrderException;
import com.scm.Supply.chain.apis.Exceptions.OrderNotFoundException;
import com.scm.Supply.chain.apis.Exceptions.ProductNotFoundException;
import com.scm.Supply.chain.apis.Service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) throws InvalidOrderException, ProductNotFoundException {
        return orderService.createOrder(order);
    }

    @GetMapping("/{orderId}")
    public Product getOrderById(@PathVariable Long orderId) throws OrderNotFoundException {
        return orderService.getOrderById(orderId);
    }

    @GetMapping
    public List<Product> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("/{orderId}")
    public Product updateOrder(@PathVariable Long orderId, @RequestBody Order order) throws OrderNotFoundException {
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) throws OrderNotFoundException {
        orderService.deleteOrder(orderId);
    }
}
