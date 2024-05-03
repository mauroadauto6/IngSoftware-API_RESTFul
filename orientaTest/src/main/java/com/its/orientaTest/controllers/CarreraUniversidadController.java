package com.its.orientaTest.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.its.orientaTest.model.dto.CarreraUniversidadRequestDTO;
import com.its.orientaTest.model.dto.CarreraUniversidadResponseDTO;
import com.its.orientaTest.service.CarreraUniversidadService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/carreras-universidades")
@AllArgsConstructor
public class CarreraUniversidadController {

    private final CarreraUniversidadService carreraUniversidadService;

    // Maneja las solicitudes de tipo GET para obtener una lista de todas las relaciones entre carreras y universidades
    @GetMapping
    public ResponseEntity<List<CarreraUniversidadResponseDTO>> obtenerTodasLasCarrerasUniversidades() {
        List<CarreraUniversidadResponseDTO> carrerasUniversidades = carreraUniversidadService.obtenerTodasLasCarrerasUniversidades();
        return ResponseEntity.ok(carrerasUniversidades);
    }

    // Maneja las solicitudes de tipo GET para obtener una relación específica entre carrera y universidad por ID
    @GetMapping("/{id}")
    public ResponseEntity<CarreraUniversidadResponseDTO> obtenerCarreraUniversidadPorId(@PathVariable Long id) {
        CarreraUniversidadResponseDTO carreraUniversidad = carreraUniversidadService.obtenerCarreraUniversidadPorId(id);
        return ResponseEntity.ok(carreraUniversidad);
    }

    // Maneja las solicitudes de tipo POST para crear una nueva relación entre carrera y universidad
    @PostMapping
    public ResponseEntity<CarreraUniversidadResponseDTO> crearCarreraUniversidad(@RequestBody CarreraUniversidadRequestDTO requestDTO) {
        CarreraUniversidadResponseDTO nuevaCarreraUniversidad = carreraUniversidadService.crearCarreraUniversidad(requestDTO);
        return ResponseEntity.ok(nuevaCarreraUniversidad);
    }
}
