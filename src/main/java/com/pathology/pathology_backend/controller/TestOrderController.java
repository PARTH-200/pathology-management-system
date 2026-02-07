package com.pathology.pathology_backend.controller;

import com.pathology.pathology_backend.entity.TestOrder;
import com.pathology.pathology_backend.service.TestOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("*")
public class TestOrderController {

    private final TestOrderService orderService;

    public TestOrderController(TestOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public TestOrder createOrder(@RequestParam String patientName,
                                 @RequestParam String phone,
                                 @RequestParam Long testId) {
        return orderService.createOrder(patientName, phone, testId);
    }

    @GetMapping("/today")
    public List<TestOrder> todayOrders() {
        return orderService.getTodayOrders();
    }

    @PutMapping("/{id}/result")
    public TestOrder enterResult(@PathVariable Long id,
                                 @RequestParam String result,
                                 @RequestParam String notes) {
        return orderService.enterResult(id, result, notes);
    }
}
