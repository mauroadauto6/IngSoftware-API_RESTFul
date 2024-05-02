package com.its.orientaTest.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaResponseDTO {
    private Long id;
    private String Enunciado;
    private String nombreCategoria;
}
