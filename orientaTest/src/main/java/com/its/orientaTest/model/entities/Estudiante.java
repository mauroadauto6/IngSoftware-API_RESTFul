package com.its.orientaTest.model.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "estudiantes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "correo_electronico", nullable = false)
    private String correoElectronico;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;

    @Column(name = "direccion", nullable = false)
    private String direccion;

   @Column(name = "fecha", nullable = false)
   private LocalDate fechaRegistro;

   @Column(name = "intentos_test", nullable = false)
    private Integer intentosTest;

}

