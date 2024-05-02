package com.its.orientaTest.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Suscripciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Suscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_suscripcion", nullable = false)
    private LocalDate fechaSuscipcion;

    @Column(name = "estado_suscripcion", nullable = false)
    private String estadoSuscripcion;

    @OneToOne
    @JoinColumn(name = "estudent_id", nullable = false)
    private Estudiante estudiante;
}
