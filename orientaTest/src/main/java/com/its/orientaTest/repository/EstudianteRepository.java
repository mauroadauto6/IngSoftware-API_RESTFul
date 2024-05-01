package com.its.orientaTest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.its.orientaTest.model.entities.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    @Query("SELECT e FROM Estudiante e WHERE e.correoElectronico = ?1")
    Optional<Estudiante> findByCorreoElectronico(String correoElectronico);

    @Query("SELECT e FROM Estudiante e WHERE e.nombre = ?1 AND e.apellido = ?2")
    Optional<Estudiante> findByNombreAndApellido(String nombre, String apellido);

    @Query("SELECT e FROM Estudiante e WHERE e.fechaRegistro > ?1")
    List<Estudiante> findAllByFechaRegistroAfter(java.sql.Date fechaRegistro);
    @Query("SELECT COUNT(t) FROM Test t WHERE t.estudiante.id = ?1")
    long countTestsByEstudianteId(Integer idEstudiante);
}


