package com.its.orientaTest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarreraRequestDTO {
    private String nombre;       // Nombre de la carrera
    private String descripcion;  // Descripción de la carrera
}
