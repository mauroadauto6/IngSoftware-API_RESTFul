package com.its.orientaTest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.its.orientaTest.exceptions.BadRequestException;
import com.its.orientaTest.exceptions.ResourceNotFoundException;
import com.its.orientaTest.mapper.EstudianteMapper;
import com.its.orientaTest.model.dto.EstudianteRequestDTO;
import com.its.orientaTest.model.dto.EstudianteResponseDTO;
import com.its.orientaTest.model.entities.Estudiante;
import com.its.orientaTest.repository.EstudianteRepository;

import jakarta.transaction.Transactional;
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


    public EstudianteResponseDTO obtenerEstudiantePorId(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado con ID: " + id));
        return estudianteMapper.toDTO(estudiante);
    }

    public EstudianteResponseDTO crearEstudiante(EstudianteRequestDTO estudianteRequestDTO) {
        // Verifica si el correo electrónico ya existe
        if (estudianteRepository.findByCorreoElectronico(estudianteRequestDTO.getCorreoElectronico()).isPresent()) {
            throw new BadRequestException("El correo electrónico ya está en uso.");
        }
        
        // Convierte el DTO a la entidad Estudiante
        Estudiante estudiante = estudianteMapper.convertToEntity(estudianteRequestDTO);
    
        // Asegúrate de que el objeto `estudiante` contiene una contraseña válida antes de guardarlo
        if (estudiante.getContrasenia() == null || estudiante.getContrasenia().isEmpty()) {
            throw new BadRequestException("La contraseña es requerida.");
        }
        
        // Guarda el estudiante en el repositorio
        estudiante = estudianteRepository.save(estudiante);
    
        // Convierte la entidad Estudiante a EstudianteResponseDTO
        return estudianteMapper.toDTO(estudiante);
    }

    public List<EstudianteResponseDTO> obtenerTodosLosEstudiantes() {
        // Obtener la lista de todos los estudiantes desde el repositorio
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        
        // Convertir la lista de entidades Estudiante a una lista de EstudianteResponseDTO
        List<EstudianteResponseDTO> estudiantesResponseDTO = estudianteMapper.toDTOList(estudiantes);
        
        // Devolver la lista de estudiantes en forma de EstudianteResponseDTO
        return estudiantesResponseDTO;
    }

    public EstudianteResponseDTO autenticarEstudiante(String correoElectronico, String contrasenia) {
        // Busca el estudiante por correo electrónico
        Estudiante estudiante = estudianteRepository.findByCorreoElectronico(correoElectronico)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado con correo: " + correoElectronico));
        
        // Verifica que la contraseña coincida
        if (!estudiante.getContrasenia().equals(contrasenia)) {
            throw new BadRequestException("Correo electrónico o contraseña incorrectos.");
        }
        
        // Convierte la entidad Estudiante a EstudianteResponseDTO y devuélvela
        return estudianteMapper.toDTO(estudiante);
    }

    @Transactional
    public void eliminarEstudiante(Long id) {
        // Busca el estudiante por su ID
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado con ID: " + id));
        
        // Elimina el estudiante del repositorio
        estudianteRepository.delete(estudiante);
    }

    public EstudianteResponseDTO actualizarEstudiante(Long id, EstudianteRequestDTO estudianteRequestDTO) {
        // Buscar el estudiante por ID
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado con ID: " + id));
        
        // Actualizar los datos del estudiante con los datos del DTO
        estudianteMapper.updateEntity(estudiante, estudianteRequestDTO);
        
        // Guardar los cambios
        estudiante = estudianteRepository.save(estudiante);
        
        // Convertir el estudiante actualizado a EstudianteResponseDTO
        return estudianteMapper.toDTO(estudiante);
    }
}

