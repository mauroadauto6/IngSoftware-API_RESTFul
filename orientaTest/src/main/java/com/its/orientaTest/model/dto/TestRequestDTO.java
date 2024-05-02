package com.its.orientaTest.model.dto;

import lombok.Data;

@Data
public class TestRequestDTO {
    private Long preguntaId;
    private PreguntaRequestDTO preguntaRequestDTO;
}