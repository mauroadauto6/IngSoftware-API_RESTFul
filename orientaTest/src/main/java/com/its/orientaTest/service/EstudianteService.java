package com.its.orientaTest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.its.orientaTest.exceptions.ResourceNotFoundException;
import com.its.orientaTest.mapper.EstudianteMapper;
import com.its.orientaTest.model.dto.EstudianteRequestDTO;
import com.its.orientaTest.model.dto.EstudianteResponseDTO;
import com.its.orientaTest.model.entities.Estudiante;
import com.its.orientaTest.repository.EstudianteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstudianteService {
    
    private final EstudianteRepository estudianteRepository;
    private final EstudianteMapper estudianteMapper;

    public EstudianteResponseDTO obtenerEstudiantePorNombreYApellido(String nombre, String apellido) {
        Estudiante estudiante = estudianteRepository.findByNombreAndApellido()
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado con nombre: " + nombre + " y apellido: " + apellido));
        return estudianteMapper.toDTO(estudiante);
    }

    public EstudianteResponseDTO obtenerEstudiantePorCorreoElectronico(String correoElectronico) {
        Estudiante estudiante = estudianteRepository.findByCorreoElectronico(correoElectronico)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado con correo: " + correoElectronico));
        return estudianteMapper.toDTO(estudiante);
    }

    public List<EstudianteResponseDTO> obtenerEstudiantesPorFechaRegistro(java.sql.Date fechaRegistro) {
        List<Estudiante> estudiantes = estudianteRepository.findAllByFechaRegistroAfter(fechaRegistro);
        return estudianteMapper.toDTOList(estudiantes);
    }

    public EstudianteResponseDTO actualizarEstudiante(Long id, EstudianteRequestDTO estudianteRequestDTO) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado con ID: " + id));
        
        estudianteMapper.updateEntity(estudiante, estudianteRequestDTO);
        estudiante = estudianteRepository.save(estudiante);
        
        return estudianteMapper.toDTO(estudiante);
    }

    public EstudianteResponseDTO obtenerEstudiantePorId(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado con ID: " + id));
        return estudianteMapper.toDTO(estudiante);
    }
}