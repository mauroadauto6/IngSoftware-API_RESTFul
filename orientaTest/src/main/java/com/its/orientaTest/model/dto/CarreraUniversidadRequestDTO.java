package com.its.orientaTest.model.dto;

import com.its.orientaTest.model.entities.Carrera;
import com.its.orientaTest.model.entities.Universidad;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarreraUniversidadRequestDTO {
    @NotNull(message = "Es necesario el id de carrera")
    Carrera carrera;
    @NotNull(message = "Es necesario el id de universidad")
    Universidad universidad;
}
