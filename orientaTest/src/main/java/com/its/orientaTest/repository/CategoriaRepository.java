package com.its.orientaTest.repository;

import com.its.orientaTest.model.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

   // Categoria save(Categoria respuesta);


}
