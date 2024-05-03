package com.its.orientaTest.service;

import com.its.orientaTest.model.dto.TestRequestDTO;
import com.its.orientaTest.model.dto.TestResponseDTO;
import com.its.orientaTest.model.entities.Test;
import com.its.orientaTest.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService {

    private final TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<TestResponseDTO> getAllTestsWithCategories() {
        List<Object[]> testsData = testRepository.findAllTestIdsAndCategories();
        return testsData.stream()
                        .map(testData -> {
                            TestResponseDTO testResponseDTO = new TestResponseDTO();
                            testResponseDTO.setId((Long) testData[0]);
                            testResponseDTO.setTipoTest((String) testData[1]);
                            return testResponseDTO;
                        })
                        .collect(Collectors.toList());
    }

    public TestResponseDTO saveTest(TestRequestDTO testRequestDTO) {
        Test test = new Test();
        test.setTipoTest(testRequestDTO.getTipoTest());
        test.setFechaTest(testRequestDTO.getFechaTest());
        // Aquí podrías agregar la lógica para obtener el estudiante correspondiente
        // test.setEstudiante(estudiante); 
        Test savedTest = testRepository.save(test);

        TestResponseDTO testResponseDTO = new TestResponseDTO();
        testResponseDTO.setId(savedTest.getId());
        testResponseDTO.setTipoTest(savedTest.getTipoTest());
        return testResponseDTO;
    }
}