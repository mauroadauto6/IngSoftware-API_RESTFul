package com.its.orientaTest.mapper;


import com.its.orientaTest.model.dto.PreguntaRequestDTO;
import com.its.orientaTest.model.dto.PreguntaResponseDTO;
import com.its.orientaTest.model.entities.Pregunta;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@AllArgsConstructor
@Component
public class PreguntaMapper {

        private final ModelMapper modelMapper;

        public PreguntaMapper(ModelMapper modelMapper) {
            this.modelMapper = modelMapper;
        }

    public Pregunta convertToEntity(PreguntaRequestDTO preguntaRequestDTO){
            return modelMapper.map(preguntaRequestDTO, Pregunta.class);
        }

        public PreguntaResponseDTO convertToDTO(Pregunta pregunta){
            return modelMapper.map(pregunta, PreguntaResponseDTO.class);
        }

        public List<PreguntaResponseDTO> convertToListDTO(List<Pregunta> pregunta){
            return pregunta.stream().map(this::convertToDTO).toList();
        }

    }