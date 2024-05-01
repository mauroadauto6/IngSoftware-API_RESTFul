package com.its.orientaTest.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.its.orientaTest.model.entities.Estudiante;
import com.its.orientaTest.model.dto.EstudianteRequestDTO;

@Component

public class EstudianteMapper {

    private final ModelMapper modelMapper;

    public EstudianteMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Estudiante convertToEntity(EstudianteRequestDTO estudianteRequestDTO){
        return modelMapper.map(estudianteRequestDTO,Estudiante.class);

    }
}
