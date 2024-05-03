package com.its.orientaTest.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "universidad")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Universidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @Column(name = "correo_electronico", nullable = false, unique = true)
    private String correoElectronico;

    @Column(name = "telefono", nullable = false, unique = true)
    private String telefono;

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Column(name = "ranking", nullable = false)
    private Integer ranking;
}
