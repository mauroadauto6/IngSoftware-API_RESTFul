package com.its.orientaTest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.its.orientaTest.model.entities.Carrera;
import com.its.orientaTest.model.entities.Estudiante;

public interface CarreraRepository extends JpaRepository<Estudiante, Long> {
    
    @Query("SELECT c FROM Carrera c")
    List<Carrera> findAllCarreras();
    @Query("SELECT c FROM Carrera c WHERE c.id = ?1")
    Optional<Carrera> findCarreraById(Integer id);
} 
