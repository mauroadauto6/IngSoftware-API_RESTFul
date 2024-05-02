package com.its.orientaTest.model.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarreraRequestDTO {
    @NotBlank(message = "Debe de incluir nombre de la carrera")
    private Long nombre;

}
