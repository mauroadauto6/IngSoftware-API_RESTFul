package com.its.orientaTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.its.orientaTest.model.entities.CarreraUniversidad;

import java.util.List;

public interface CarreraUniversidadRepository extends JpaRepository<CarreraUniversidad, Long>{
    @Query("SELECT cu FROM CarreraUniversidad cu ORDER BY RAND() DESC")
    List<CarreraUniversidad> findRandomRow();
}
