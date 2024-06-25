package com.scm.Supply.chain.apis.Service;

import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Cart;
import com.scm.Supply.chain.apis.Entity.Product;
import com.scm.Supply.chain.apis.Repo.CartRepository;

@Service
public class CartService {
	
    private final CartRepository cartRepository;
    
    private final ProductService productService;

    public CartService(CartRepository cartRepository, ProductService productService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
    }

    public Cart addToCart(Long productId, int quantity) {
        Product product = productService.getProductById(productId);
        Cart cart = new Cart();
        cart.getProducts().add(product);
        cart.setTotal(cart.getTotal() + product.getPrice() * quantity);
        return cartRepository.save(cart);
    }

    public Cart getCart(Long id) {
        return cartRepository.findById(id).orElseThrow(() -> new Exception("Cart not found"));
    }
}

