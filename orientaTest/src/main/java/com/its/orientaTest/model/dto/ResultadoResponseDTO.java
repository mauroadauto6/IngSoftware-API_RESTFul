package com.its.orientaTest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoResponseDTO {
    private Long idTest;
    private Long idCarrera;
    private String NombreCarrera;
    private Long idUniversidad;
    private String NombreUniversidad;
    private Integer rankingUniversidad;
}
