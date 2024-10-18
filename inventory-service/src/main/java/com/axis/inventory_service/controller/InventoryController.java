package com.axis.inventory_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.axis.inventory_service.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

  private final InventoryService inventoryService;

  @GetMapping("/{sku-code}")
  @ResponseStatus(HttpStatus.OK)
  public Boolean isInStock(@PathVariable("sku-code") String skuCode) {
    return inventoryService.isInStock(skuCode);
  }
}
