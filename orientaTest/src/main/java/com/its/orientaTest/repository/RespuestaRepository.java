package com.its.orientaTest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.its.orientaTest.model.entities.Respuesta;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    // Método para validar una respuesta
    @Query("SELECT r FROM Respuesta r WHERE r.valor = ?1")
    Respuesta findByValor(Integer valor);

    // Método para obtener una respuesta por su ID
    Optional<Respuesta> findById(Long id);
}
