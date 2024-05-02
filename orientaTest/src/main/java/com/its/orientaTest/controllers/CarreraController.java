package com.its.orientaTest.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.its.orientaTest.model.dto.CarreraResponseDTO;
import com.its.orientaTest.service.CarreraService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/Carreras")
@AllArgsConstructor
public class CarreraController {

    private final CarreraService carreraService;
     public ResponseEntity<List<CarreraResponseDTO>> obtenerTodasLasCarreras() {
        List<CarreraResponseDTO> carreras = carreraService.obtenerTodasLasCarreras();
        return ResponseEntity.ok(carreras);
    }

     public ResponseEntity<CarreraResponseDTO> obtenerCarreraPorId(@PathVariable Integer id) {
        CarreraResponseDTO carrera = carreraService.obtenerCarreraPorId(id);
        return ResponseEntity.ok(carrera);
    }

}
