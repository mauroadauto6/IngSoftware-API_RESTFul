package com.its.orientaTest.mapper;

import com.its.orientaTest.model.dto.UniversidadRequestDTO;
import com.its.orientaTest.model.dto.UniversidadResponseDTO;
import com.its.orientaTest.model.entities.Universidad;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.modelmapper.ModelMapper;

@Component
@AllArgsConstructor
public class UniversidadMapper {

    private final ModelMapper modelMapper;

    public UniversidadResponseDTO convertToDTO(Universidad universidad){
        return modelMapper.map(universidad, UniversidadResponseDTO.class);
    }

    public List<UniversidadResponseDTO> convertToListDTO(List<Universidad> universidades){
        return universidades.stream()
                .map(this::convertToDTO)
                .toList();
    }
    
    public Universidad convertToEntity(UniversidadRequestDTO universidadRequestDTO){
        return modelMapper.map(universidadRequestDTO, Universidad.class);
    }

}
