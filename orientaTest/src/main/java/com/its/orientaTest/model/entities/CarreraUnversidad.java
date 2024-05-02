package com.its.orientaTest.model.entities;

import jakarta.persistence.*;

public class CarreraUnversidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarreraUniversidad;

    @ManyToOne
    @JoinColumn(name = "universidad_id", nullable = false)
    private  Universidad universidad;

    @ManyToOne
    @JoinColumn(name = "carrera_id", nullable = false)
    private Carrera carrera;
}
