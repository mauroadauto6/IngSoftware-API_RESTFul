package com.its.orientaTest.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.its.orientaTest.model.entities.Estudiante;
import com.its.orientaTest.model.dto.EstudianteRequestDTO;
import com.its.orientaTest.model.dto.EstudianteResponseDTO;

@Component

public class EstudianteMapper {

    private final ModelMapper modelMapper;

    public EstudianteMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Estudiante convertToEntity(EstudianteRequestDTO estudianteRequestDTO) {
        Estudiante estudiante = modelMapper.map(estudianteRequestDTO, Estudiante.class);
    
        // Verifica si fecha_registro es nulo y asígnale la fecha y hora actual si es necesario
        if (estudiante.getFechaRegistro() == null) {
            estudiante.setFechaRegistro(LocalDateTime.now());
        }
        
        // Asigna un valor por defecto a intentos_test si es nulo
        if (estudiante.getIntentosTest() == null) {
            estudiante.setIntentosTest(0);  // Ajusta el valor por defecto según sea necesario
        }

        return estudiante;
    }

    public EstudianteResponseDTO toDTO(Estudiante estudiante) {
        return modelMapper.map(estudiante, EstudianteResponseDTO.class);
    }

     public List<EstudianteResponseDTO> toDTOList(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void updateEntity(Estudiante estudiante, EstudianteRequestDTO estudianteRequestDTO) {
        modelMapper.map(estudianteRequestDTO, estudiante);
    }
}
