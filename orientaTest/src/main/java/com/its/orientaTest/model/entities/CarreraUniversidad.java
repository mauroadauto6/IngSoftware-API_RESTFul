package com.its.orientaTest.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "carreraUniversidad")
@AllArgsConstructor
@NoArgsConstructor

public class CarreraUniversidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "carrera", nullable = false)
    private String carrera;

    @Column(name = "universidad", nullable = false)
    private String universidad;
}