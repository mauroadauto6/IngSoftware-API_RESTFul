package com.its.orientaTest.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping
    public ResponseEntity<List<EstudianteResponseDTO>> obtenerTodosLosEstudiantes() {
        List<EstudianteResponseDTO> estudiantes = estudianteService.obtenerTodosLosEstudiantes();
        return ResponseEntity.ok(estudiantes);
}

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

    @PostMapping
    public ResponseEntity<EstudianteResponseDTO> crearEstudiante(@RequestBody EstudianteRequestDTO estudianteRequestDTO) {
        // Asegúrate de que el DTO contiene una contraseña válida antes de pasarlo al servicio.
        if (estudianteRequestDTO.getContrasenia() == null || estudianteRequestDTO.getContrasenia().isEmpty()) {
            throw new BadRequestException("La contraseña es requerida.");
        }
        
        EstudianteResponseDTO estudianteCreado = estudianteService.crearEstudiante(estudianteRequestDTO);
        return new ResponseEntity<>(estudianteCreado, HttpStatus.CREATED);
    }

    @PostMapping("/autenticar")
    public ResponseEntity<EstudianteResponseDTO> autenticarEstudiante(@RequestBody EstudianteRequestDTO estudianteRequestDTO) {
        // Obtener los datos de correo y contraseña del cuerpo de la solicitud
        String correoElectronico = estudianteRequestDTO.getCorreoElectronico();
        String contrasenia = estudianteRequestDTO.getContrasenia();
        
        // Autentica al estudiante
        EstudianteResponseDTO estudianteAutenticado = estudianteService.autenticarEstudiante(correoElectronico, contrasenia);
        
        // Devuelve los datos del estudiante autenticado
        return ResponseEntity.ok(estudianteAutenticado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        // Llama al servicio para eliminar al estudiante por su ID
        estudianteService.eliminarEstudiante(id);
        // Devuelve una respuesta con código de estado 204 (No Content)
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteResponseDTO> actualizarEstudiante(
            @PathVariable Long id, 
            @RequestBody EstudianteRequestDTO estudianteRequestDTO) {
        
        EstudianteResponseDTO estudianteActualizado = estudianteService.actualizarEstudiante(id, estudianteRequestDTO);
        return ResponseEntity.ok(estudianteActualizado);
    }
}
