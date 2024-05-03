package com.its.orientaTest.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
<<<<<<< HEAD
import java.util.List;
import java.util.ArrayList;
=======
>>>>>>> 6a399027ef3bf553783515118d3584244f644b54

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
<<<<<<< HEAD

    @ManyToMany
    @JoinTable(
        name = "test_pregunta",
        joinColumns = @JoinColumn(name = "test_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "pregunta_id", referencedColumnName = "id")
    )
    private List<Pregunta> preguntas = new ArrayList<>();
=======
>>>>>>> 6a399027ef3bf553783515118d3584244f644b54
}
