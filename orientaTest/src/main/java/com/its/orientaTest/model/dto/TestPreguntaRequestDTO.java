package com.its.orientaTest.model.dto;

import jakarta.validation.constraints.NotNull;

public class TestPreguntaRequestDTO {

    @NotNull(message = "Necesario el id test")
    private Long idTest;

    @NotNull(message = "Necesario el id pregunta")
    private Long idPregunta;
}
