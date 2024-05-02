package com.its.orientaTest.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarreraResponseDTO {
    private Long id;
    private String nombre;
    private String descripcion;
}
