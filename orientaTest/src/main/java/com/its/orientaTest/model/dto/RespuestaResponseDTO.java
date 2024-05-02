package com.its.orientaTest.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaResponseDTO {
    private Long id;
    private Long idPregunta;
    private String enunciado;
    private Integer valor;
}
