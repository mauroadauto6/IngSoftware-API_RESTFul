package com.its.orientaTest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.its.orientaTest.exception.ResourceNotFoundException;
import com.its.orientaTest.mapper.CarreraMapper;
import com.its.orientaTest.model.dto.CarreraResponseDTO;
import com.its.orientaTest.model.entities.Carrera;
import com.its.orientaTest.repository.CarreraRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarreraService {
    private final CarreraRepository carreraRepository;
    private final CarreraMapper carreraMapper;

     public List<CarreraResponseDTO> obtenerTodasLasCarreras() {
        List<Carrera> carreras = carreraRepository.findAllCarreras();
        return carreraMapper.toDTOList(carreras);
    }


    public CarreraResponseDTO obtenerCarreraPorId(Integer id) {
        // Buscar la carrera por ID en el repositorio
        Carrera carrera = carreraRepository.findCarreraById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carrera no encontrada con ID: " + id));
        
        // Convertir la entidad Carrera a un objeto CarreraResponseDTO utilizando el mapper
        return carreraMapper.toDTO(carrera);
    }
}
