package com.its.orientaTest.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.its.orientaTest.model.dto.CarreraRequestDTO;
import com.its.orientaTest.model.dto.CarreraResponseDTO;
import com.its.orientaTest.service.CarreraService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/Carreras")
@AllArgsConstructor
public class CarreraController {

    private final CarreraService carreraService;
    @GetMapping
    public List<CarreraResponseDTO> obtenerTodasLasCarreras() {
        // Llama al servicio para obtener todas las carreras
        List<CarreraResponseDTO> carreras = carreraService.obtenerTodasLasCarreras();
        // Devuelve la lista de carreras como respuesta
        return carreras;
    }

     public ResponseEntity<CarreraResponseDTO> obtenerCarreraPorId(@PathVariable Integer id) {
        CarreraResponseDTO carrera = carreraService.obtenerCarreraPorId(id);
        return ResponseEntity.ok(carrera);
    }

    @PostMapping
    public ResponseEntity<CarreraResponseDTO> crearCarrera(@RequestBody CarreraRequestDTO carreraRequestDTO) {
        CarreraResponseDTO carreraCreada = carreraService.crearCarrera(carreraRequestDTO);
        return ResponseEntity.ok(carreraCreada);
    }
}
