package com.its.orientaTest.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Resultados")
@AllArgsConstructor
@NoArgsConstructor
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carrera_universidad_id", nullable = false)
    private CarreraUnversidad carreraunversidad;

    @OneToOne()
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;
}
