package com.scm.Supply.chain.apis.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Order;
import com.scm.Supply.chain.apis.Entity.Product;
import com.scm.Supply.chain.apis.Exceptions.InvalidOrderException;
import com.scm.Supply.chain.apis.Exceptions.OrderNotFoundException;
import com.scm.Supply.chain.apis.Exceptions.ProductNotFoundException;
import com.scm.Supply.chain.apis.Repo.OrderRepository;
import com.scm.Supply.chain.apis.Repo.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	
    private final OrderRepository orderRepository;
    
    private final ProductRepository productRepository;

	@Autowired
    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

	@Transactional
    public Order createOrder(Order order) throws InvalidOrderException, ProductNotFoundException {
        // Validate order details
        if (order.getProducts().isEmpty()) {
            throw new InvalidOrderException("Order must contain at least one product.");
        }
//        for (Product product : order.getProducts()) {
//            if (!productRepository.existsById(product.getId())) {
//                throw new ProductNotFoundException("Product not found: " + product.getId());
//            }
//        }
        return orderRepository.save(order);
    }

    public Product getOrderById(Long orderId) throws OrderNotFoundException {
        return productRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found: " + orderId));
    }

    public List<Product> getAllOrders() {
        return productRepository.findAll();
    }

    public Product updateOrder(Order order) throws OrderNotFoundException {
    	Product existingOrder = getOrderById(order.getId());
    	existingOrder.setId(order.getId());
    	for(Product item : order.getProducts()) {
    		existingOrder.setName(item.getName());
    		existingOrder.setOrder(item.getOrder());
    		existingOrder.setPrice(item.getPrice());
    	}
        return productRepository.save(existingOrder);
    }

    public void deleteOrder(Long orderId) throws OrderNotFoundException {
    	Product order = getOrderById(orderId);
    	productRepository.delete(order);
    }
}
