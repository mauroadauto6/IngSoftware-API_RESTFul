package com.its.orientaTest.model.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaRequestDTO {
    @NotNull(message = "Es necesario el id de la pregunta")
    private Long idPregunta;

    @NotBlank(message = "Es necesario el valor de la pregunta")
    private Integer valor;

}
