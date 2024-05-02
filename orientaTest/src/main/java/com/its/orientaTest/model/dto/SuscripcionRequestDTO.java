package com.its.orientaTest.model.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuscripcionRequestDTO {

    @NotNull(message = "Debe de incluir el id")
    private Long idEstudiante;

    @NotBlank(message = "Debe de incluir el estado de la suscripcion")
    private String estadoSuscripcion;


}
