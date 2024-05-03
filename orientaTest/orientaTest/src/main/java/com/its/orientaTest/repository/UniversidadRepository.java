package com.its.orientaTest.repository;

import com.its.orientaTest.model.entities.Universidad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface UniversidadRepository extends JpaRepository<Universidad,Long>{
    List<Universidad> findByNombre(String nombre);
}
