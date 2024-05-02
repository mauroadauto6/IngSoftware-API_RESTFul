package com.its.orientaTest.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Test_Preguntas")
@NoArgsConstructor
@AllArgsConstructor
public class TestPregunta {

    @ManyToOne
    @JoinColumn(name = "id_test", nullable = false)
    private Test test;

    @ManyToOne
    @JoinColumn(name = "id_pregunta", nullable = false)
    private Pregunta pregunta;
}
