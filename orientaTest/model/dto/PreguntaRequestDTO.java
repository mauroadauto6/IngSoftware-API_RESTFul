package com.its.orientaTest.model.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaRequestDTO {
    @NotBlank(message = "Debe de tener enunciado")
    private String enunciado;

    @NotNull(message = "Debe de contener un id_categoria")
    private Long idCategoria;

}
