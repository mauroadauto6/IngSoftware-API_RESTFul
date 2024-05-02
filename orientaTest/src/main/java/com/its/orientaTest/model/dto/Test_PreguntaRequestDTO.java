package com.its.orientaTest.model.dto;

import jakarta.validation.constraints.NotNull;

public class Test_PreguntaRequestDTO {
    @NotNull(message = "Necesario el id test")
    private Long testId;

    @NotNull(message = "Necesario el id pregunta")
    private Long preguntaId;
}
