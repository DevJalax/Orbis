package com.scm.Supply.chain.apis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.Entity.Cart;
import com.scm.Supply.chain.apis.Service.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartController {
	
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/{productId}")
    public Cart addToCart(@PathVariable Long productId, @RequestParam int quantity) {
        return cartService.addToCart(productId, quantity);
    }

    @GetMapping("/{id}")
    public Cart getCart(@PathVariable Long id) {
        return cartService.getCart(id);
    }
}
