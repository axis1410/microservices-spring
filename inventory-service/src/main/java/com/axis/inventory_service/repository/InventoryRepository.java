package com.axis.inventory_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.inventory_service.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
  Optional<Inventory> findBySkuCode(String skuCode);
}
