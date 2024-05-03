package com.its.orientaTest.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarreraUniversidadResponseDTO{
    private Long Id;
    private CarreraResponseDTO carrera;
    private UniversidadResponseDTO universidad;
}
   
