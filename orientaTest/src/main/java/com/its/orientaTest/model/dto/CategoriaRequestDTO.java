package com.its.orientaTest.model.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoriaRequestDTO {
    @NotBlank(message = "Debe contener el nombre")
    private String nombre;

}
