package com.its.orientaTest.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.its.orientaTest.model.dto.RespuestaRequestDTO;
import com.its.orientaTest.model.dto.RespuestaResponseDTO;
import com.its.orientaTest.model.entities.Respuesta;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Component
public class RespuestaMapper {
    private final ModelMapper modelMapper;
    
    public Respuesta convertToEntity(RespuestaRequestDTO respuestaRequestDTO) {
        return modelMapper.map(respuestaRequestDTO, Respuesta.class);
    }

    public RespuestaResponseDTO convertToDTO(Respuesta respuesta) {
        return modelMapper.map(respuesta, RespuestaResponseDTO.class);
    }

    public List<RespuestaResponseDTO> convertToListDTO(List<Respuesta> respuestas){
        return respuestas.stream().map(this::convertToDTO).toList();
    }
}
