package com.its.orientaTest.model.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class TestResponseDTO {
    private String tipoTest;
    private LocalDate fechaTest;
    private List<PreguntaResponseDTO> preguntas;
}
