package com.its.orientaTest.controllers;

import com.its.orientaTest.model.dto.TestRequestDTO;
import com.its.orientaTest.model.dto.TestResponseDTO;
import com.its.orientaTest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tests")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    // Endpoint para obtener todos los tests
    @GetMapping
    public ResponseEntity<List<TestResponseDTO>> getAllTests() {
        List<TestResponseDTO> tests = testService.getAllTestsWithCategories();
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }

    // Endpoint para crear un nuevo test
    @PostMapping
    public ResponseEntity<TestResponseDTO> createTest(@RequestBody TestRequestDTO testRequestDTO) {
        TestResponseDTO createdTest = testService.saveTest(testRequestDTO);
        return new ResponseEntity<>(createdTest, HttpStatus.CREATED);
    }
}