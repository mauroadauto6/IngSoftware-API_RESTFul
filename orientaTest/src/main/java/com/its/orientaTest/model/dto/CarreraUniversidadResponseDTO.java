package com.its.orientaTest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarreraUniversidadResponseDTO {
    private String nombreCarrera;
    private String descripcionCarrera;
    private String nombreUniversidad;
    private String correoElectronico;
    private String telefono;
    private Integer Ranking;
    private String ubicacion;

}
