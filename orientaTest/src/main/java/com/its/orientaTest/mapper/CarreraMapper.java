package com.its.orientaTest.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.its.orientaTest.model.dto.CarreraRequestDTO;
import com.its.orientaTest.model.dto.CarreraResponseDTO;
import com.its.orientaTest.model.entities.Carrera;

@Component
public class CarreraMapper {
      private final ModelMapper modelMapper;

    public CarreraMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Carrera convertToEntity (CarreraRequestDTO carreraRequestDTO){
        return modelMapper.map(carreraRequestDTO, Carrera.class);
    }

    public CarreraResponseDTO toDTO(Carrera carrera) {
        return modelMapper.map(carrera, CarreraResponseDTO.class);
    }

    public List<CarreraResponseDTO> toDTOList(List<Carrera> carreras) {
        return carreras.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
