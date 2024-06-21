package com.scm.Supply.chain.apis.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.Supply.chain.apis.Entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {

}
