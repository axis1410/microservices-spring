package com.axis.order_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.order_service.dto.OrderRequest;
import com.axis.order_service.model.Order;
import com.axis.order_service.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

  private final OrderService orderService;

  @PostMapping
  public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest orderRequest) {
    Order order = orderService.placeOrder(orderRequest);

    return ResponseEntity.status(HttpStatus.CREATED).body(order);
  }

  @GetMapping
  public ResponseEntity<Iterable<Order>> getOrders() {
    Iterable<Order> orders = orderService.getOrders();

    return ResponseEntity.ok(orders);
  }
}
