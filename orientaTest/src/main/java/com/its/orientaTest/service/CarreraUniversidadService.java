package com.its.orientaTest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.its.orientaTest.exceptions.ResourceNotFoundException;
import com.its.orientaTest.mapper.CarreraUniversidadMapper;
import com.its.orientaTest.model.dto.CarreraUniversidadRequestDTO;
import com.its.orientaTest.model.dto.CarreraUniversidadResponseDTO;
import com.its.orientaTest.model.entities.CarreraUniversidad;
import com.its.orientaTest.repository.CarreraUniversidadRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarreraUniversidadService {
    private final CarreraUniversidadRepository carreraUniversidadRepository;
    private final CarreraUniversidadMapper carreraUniversidadMapper;    

    // Obtener todas las relaciones entre carreras y universidades
    public List<CarreraUniversidadResponseDTO> obtenerTodasLasCarrerasUniversidades() {
        List<CarreraUniversidad> carrerasUniversidades = carreraUniversidadRepository.findAllCarrerasUniversidades();
        return carreraUniversidadMapper.toDTOList(carrerasUniversidades);
    }

    // Obtener una relación específica entre carrera y universidad por ID
    public CarreraUniversidadResponseDTO obtenerCarreraUniversidadPorId(Long id) {
        CarreraUniversidad carreraUniversidad = carreraUniversidadRepository.findCarreraUniversidadById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CarreraUniversidad no encontrada con ID: " + id));
        return carreraUniversidadMapper.toDTO(carreraUniversidad);
    }

    // Crear una nueva relación entre carrera y universidad
    public CarreraUniversidadResponseDTO crearCarreraUniversidad(CarreraUniversidadRequestDTO requestDTO) {
        // Convertir el DTO a la entidad CarreraUniversidad
        CarreraUniversidad carreraUniversidad = carreraUniversidadMapper.toEntity(requestDTO);
        
        // Guardar la nueva relación en el repositorio
        CarreraUniversidad carreraUniversidadGuardada = carreraUniversidadRepository.save(carreraUniversidad);
        
        // Convertir la entidad CarreraUniversidad a un objeto CarreraUniversidadResponseDTO utilizando el mapper
        return carreraUniversidadMapper.toDTO(carreraUniversidadGuardada);
    }

    // Eliminar una relación específica entre carrera y universidad por ID
    public void eliminarCarreraUniversidad(Long id) {
        // Verifica si existe la relación a eliminar
        CarreraUniversidad carreraUniversidad = carreraUniversidadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CarreraUniversidad no encontrada con ID: " + id));
        
        // Eliminar la relación
        carreraUniversidadRepository.delete(carreraUniversidad);
    }
}
