package com.its.orientaTest.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteRequestDTO {

    @NotBlank(message = "El nombre del estudiante debe estar incluido")
    @Size(min = 5, max =20, message = "El nombre debe ser mas largo")
    @Pattern(regexp = "[a-z]+", message = "Debe ser solo letras")
    private String nombre;
    @NotBlank(message = "El apellido del estudiante debe estar incluido")
    private String apellido;
    @NotBlank(message = "El correo electronico del estudiante debe estar incluido")

    private String correoElectronico;
    @Email
    @NotBlank(message = "La contraseña del estudiante debe estar incluido")

    private String contrasenia;
    @NotBlank(message = "El telefono del estudiante debe estar incluido")

    private String telefono;
    @NotBlank(message = "La direccion del estudiante debe estar incluido")

    private String direccion;
}
