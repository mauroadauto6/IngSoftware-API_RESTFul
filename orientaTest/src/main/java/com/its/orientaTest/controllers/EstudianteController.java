package com.its.orientaTest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.its.orientaTest.exceptions.BadRequestException;
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

    @PostMapping
    public ResponseEntity<EstudianteResponseDTO> crearEstudiante(@RequestBody EstudianteRequestDTO estudianteRequestDTO) {
        // Asegúrate de que el DTO contiene una contraseña válida antes de pasarlo al servicio.
        if (estudianteRequestDTO.getContrasenia() == null || estudianteRequestDTO.getContrasenia().isEmpty()) {
            throw new BadRequestException("La contraseña es requerida.");
        }
        
        EstudianteResponseDTO estudianteCreado = estudianteService.crearEstudiante(estudianteRequestDTO);
        return new ResponseEntity<>(estudianteCreado, HttpStatus.CREATED);
    }


}
