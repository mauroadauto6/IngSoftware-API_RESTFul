package com.its.orientaTest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestResponseDTO {
    private String tipoTest;
    private LocalDate fechaTest;
    private List<PreguntaResponseDTO> preguntas;
}