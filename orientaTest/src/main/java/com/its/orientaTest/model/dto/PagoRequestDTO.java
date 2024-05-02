package com.its.orientaTest.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagoRequestDTO {
    @NotNull(message = "Debe de incluir el Id")
    private Long idEstudiante;

    @NotBlank(message = "Debe de incluir un monto")
    private BigDecimal monto;
}
