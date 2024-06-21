package com.scm.Supply.chain.apis.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.Supply.chain.apis.Entity.Order;
import com.scm.Supply.chain.apis.Entity.Product;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	 List<Order> findByProductsContaining(Product product);
	
}
