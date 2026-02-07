package com.pathology.pathology_backend.repository;

import com.pathology.pathology_backend.entity.TestOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TestOrderRepository extends JpaRepository<TestOrder, Long> {
    List<TestOrder> findByOrderDate(LocalDate date);
}
