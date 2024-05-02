package com.its.orientaTest.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagoResponseDTO {
    private Long id;
    private BigDecimal monto;
    private LocalDate fechaPago;
    private Long idEstudiante;
    private String NombreEstudiante;
    private String ApellidoEstudiante;
}

