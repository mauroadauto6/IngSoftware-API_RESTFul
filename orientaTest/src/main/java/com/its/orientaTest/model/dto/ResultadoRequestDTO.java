package com.its.orientaTest.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoRequestDTO {
    @NotNull(message = "Es necesario el id de la carrera")
    private Long idCarrera;

    @NotNull(message = "Es necesario el id del test")
    private Long idTest;
}
