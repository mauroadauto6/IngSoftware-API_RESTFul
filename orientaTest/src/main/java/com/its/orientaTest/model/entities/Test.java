package com.its.orientaTest.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "test")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_test" , nullable = false)
    private String tipoTest;

    @Column(name = "fecha_test", nullable = false)
    private LocalDate fechaTest;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudiante;

    @ManyToMany
    @JoinTable(
        name = "test_pregunta",
        joinColumns = @JoinColumn(name = "test_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "pregunta_id", referencedColumnName = "id")
    )
    private Set<Pregunta> preguntas = new HashSet<>();
}
