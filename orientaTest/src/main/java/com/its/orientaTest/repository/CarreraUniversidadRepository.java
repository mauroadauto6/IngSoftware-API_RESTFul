package com.its.orientaTest.repository;

import com.its.orientaTest.model.entities.CarreraUniversidad;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CarreraUniversidadRepository extends JpaRepository<CarreraUniversidad, Long> {
    @Query("SELECT cu FROM CarreraUniversidad cu")
    List<CarreraUniversidad> findAllCarrerasUniversidades();
     // Consulta para obtener una relación específica entre carrera y universidad por ID
     @Query("SELECT cu FROM CarreraUniversidad cu WHERE cu.id = ?1")
     Optional<CarreraUniversidad> findCarreraUniversidadById(Long id);
}
