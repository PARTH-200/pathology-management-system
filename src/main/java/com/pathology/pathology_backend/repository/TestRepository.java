package com.pathology.pathology_backend.repository;

import com.pathology.pathology_backend.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> findByTestNameContainingIgnoreCase(String testName);
}
