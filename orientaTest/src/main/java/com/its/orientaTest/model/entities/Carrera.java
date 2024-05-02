package com.its.orientaTest.model.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Carreras")
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private Long nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;
}
