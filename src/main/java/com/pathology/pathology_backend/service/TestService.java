package com.pathology.pathology_backend.service;

import com.pathology.pathology_backend.entity.Test;
import com.pathology.pathology_backend.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public Test saveTest(Test test) {
        return testRepository.save(test);
    }

    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    public List<Test> searchTest(String name) {
        return testRepository.findByTestNameContainingIgnoreCase(name);
    }
}
