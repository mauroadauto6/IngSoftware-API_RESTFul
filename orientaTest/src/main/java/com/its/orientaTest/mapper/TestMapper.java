package com.its.orientaTest.mapper;

import org.springframework.stereotype.Component;

import com.its.orientaTest.model.dto.TestResponseDTO;

import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;

import com.its.orientaTest.model.entities.Test;

import java.util.List;

@Component
@AllArgsConstructor
public class TestMapper {
    private final ModelMapper modelMapper;
    public TestResponseDTO convertToDTO(Test test){
        return modelMapper.map(test, TestResponseDTO.class);
    }
    public List<TestResponseDTO> convertToDTO(List<Test> tests){
        return tests.stream()
        .map(this::convertToDTO)
        .toList();
    }
}
