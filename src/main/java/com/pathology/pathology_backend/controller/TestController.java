package com.pathology.pathology_backend.controller;

import com.pathology.pathology_backend.entity.Test;
import com.pathology.pathology_backend.service.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tests")
@CrossOrigin("*")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping
    public Test addTest(@RequestBody Test test) {
        return testService.saveTest(test);
    }

    @GetMapping
    public List<Test> getAll() {
        return testService.getAllTests();
    }

    @GetMapping("/search")
    public List<Test> search(@RequestParam String name) {
        return testService.searchTest(name);
    }
}
