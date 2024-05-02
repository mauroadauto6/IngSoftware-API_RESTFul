package com.its.orientaTest.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SuscripcionResponseDTO {
    private Long id;
    private String EstadoSuscripcion;
    private String EstudianteNombre;
    private String EstudianteApellido;
}
