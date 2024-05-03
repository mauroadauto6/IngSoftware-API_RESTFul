package com.its.orientaTest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResultadoRequestDTO {
    private Long id;
    private String test;
    private String carreraUniversidad;
}
