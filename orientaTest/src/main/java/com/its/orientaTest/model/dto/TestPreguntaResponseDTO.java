package com.its.orientaTest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestPreguntaResponseDTO {
    private Long idPregunta;
    private Long idTest;
    private String preguntaEnunciado;
    private String tipoTest;
    private LocalDate fechaTest;
}
