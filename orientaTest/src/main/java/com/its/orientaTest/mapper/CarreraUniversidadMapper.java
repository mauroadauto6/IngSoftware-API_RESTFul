package com.its.orientaTest.mapper;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.its.orientaTest.model.dto.CarreraUniversidadRequestDTO;
import com.its.orientaTest.model.dto.CarreraUniversidadResponseDTO;
import com.its.orientaTest.model.entities.CarreraUniversidad;

@Component
public class CarreraUniversidadMapper {
        private final ModelMapper modelMapper;
    public CarreraUniversidadMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public CarreraUniversidad toEntity(CarreraUniversidadRequestDTO carreraUniversidadRequestDTO){
        return modelMapper.map(carreraUniversidadRequestDTO, CarreraUniversidad.class);
    }

    public CarreraUniversidadResponseDTO toDTO(CarreraUniversidad carreraUniversidad){
        return modelMapper.map(carreraUniversidad, CarreraUniversidadResponseDTO.class);
    }
    // Convierte una lista de entidades CarreraUniversidad a una lista de DTOs CarreraUniversidadResponseDTO
    public List<CarreraUniversidadResponseDTO> toDTOList(List<CarreraUniversidad> carrerasUniversidades) {
        return carrerasUniversidades.stream()
                .map(this::toDTO) // Convierte cada entidad CarreraUniversidad a su DTO correspondiente
                .collect(Collectors.toList()); // Convierte el stream a una lista de DTOs
    }

}
