package com.axis.inventory_service.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axis.inventory_service.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

  private final InventoryRepository inventoryRepository;

  @Transactional(readOnly = true)
  public Boolean isInStock(String skuCode) {
    System.out.println("Checking stock for SKU: " + skuCode);
    System.out.println("Inventory details: " + inventoryRepository.findBySkuCode(skuCode).isEmpty());
    return inventoryRepository.findBySkuCode(skuCode).isPresent();
  }
}
