package com.its.orientaTest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.its.orientaTest.model.dto.EstudianteRequestDTO;
import com.its.orientaTest.model.dto.EstudianteResponseDTO;
import com.its.orientaTest.service.EstudianteService;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/Estudiante")
@AllArgsConstructor
public class EstudianteController {
    
    private final EstudianteService estudianteService;

     public ResponseEntity<EstudianteResponseDTO> obtenerEstudiantePorId(@PathVariable Long id) {
        EstudianteResponseDTO estudiante = estudianteService.obtenerEstudiantePorId(id);
        return ResponseEntity.ok(estudiante);
    }

    public ResponseEntity<EstudianteResponseDTO> obtenerEstudiantePorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido) {
        EstudianteResponseDTO estudiante = estudianteService.obtenerEstudiantePorNombreYApellido(nombre, apellido);
        return ResponseEntity.ok(estudiante);
    }

    public ResponseEntity<EstudianteResponseDTO> obtenerEstudiantePorCorreoElectronico(@RequestParam String correoElectronico) {
        EstudianteResponseDTO estudiante = estudianteService.obtenerEstudiantePorCorreoElectronico(correoElectronico);
        return ResponseEntity.ok(estudiante);
    }

    public ResponseEntity<EstudianteResponseDTO> actualizarEstudiante(@PathVariable Long id, @RequestBody EstudianteRequestDTO estudianteRequestDTO) {
        EstudianteResponseDTO estudianteActualizado = estudianteService.actualizarEstudiante(id, estudianteRequestDTO);
        return ResponseEntity.ok(estudianteActualizado);
    }

}
