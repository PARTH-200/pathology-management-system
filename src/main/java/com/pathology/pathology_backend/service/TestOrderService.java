package com.pathology.pathology_backend.service;

import com.pathology.pathology_backend.entity.Test;
import com.pathology.pathology_backend.entity.TestOrder;
import com.pathology.pathology_backend.repository.TestOrderRepository;
import com.pathology.pathology_backend.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class TestOrderService {

    private final TestOrderRepository orderRepository;
    private final TestRepository testRepository;

    public TestOrderService(TestOrderRepository orderRepository, TestRepository testRepository) {
        this.orderRepository = orderRepository;
        this.testRepository = testRepository;
    }

    public TestOrder createOrder(String patientName, String phone, Long testId) {
        Test test = testRepository.findById(testId).orElseThrow();

        TestOrder order = new TestOrder();
        order.setPatientName(patientName);
        order.setPhone(phone);
        order.setTest(test);
        order.setOrderDate(LocalDate.now());
        order.setOrderNumber("ORD-" + UUID.randomUUID().toString().substring(0, 8));
        order.setStatus("PENDING");

        return orderRepository.save(order);
    }

    public List<TestOrder> getTodayOrders() {
        return orderRepository.findByOrderDate(LocalDate.now());
    }

    public TestOrder enterResult(Long orderId, String result, String notes) {
        TestOrder order = orderRepository.findById(orderId).orElseThrow();
        order.setResultValue(result);
        order.setTechnicianNotes(notes);
        order.setStatus("COMPLETED");
        return orderRepository.save(order);
    }
}
