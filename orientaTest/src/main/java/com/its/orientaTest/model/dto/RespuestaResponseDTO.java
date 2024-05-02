package com.its.orientaTest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RespuestaResponseDTO {
    private Long id;
    private Long preguntaId;
    private Integer valor;    
}
