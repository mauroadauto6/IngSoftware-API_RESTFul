package com.its.orientaTest.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.its.orientaTest.model.dto.CarreraRequestDTO;
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
}
