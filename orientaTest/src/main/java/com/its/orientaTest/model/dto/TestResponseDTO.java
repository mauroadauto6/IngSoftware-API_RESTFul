package com.its.orientaTest.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestResponseDTO {
    private Long id;
    private String tipoTest;
    private LocalDate fechaTest;
    private Long idEstudiante;
    private String nombreEstudiante;
    private String apellidoEstudiante;
}
