package com.its.orientaTest.mapper;

import com.its.orientaTest.model.dto.ResultadoRequestDTO;
import com.its.orientaTest.model.dto.ResultadoResponseDTO;
import com.its.orientaTest.model.entities.Resultado;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.modelmapper.ModelMapper;

@Component
@AllArgsConstructor
public class ResultadoMapper {

    private final ModelMapper modelMapper;

    public ResultadoResponseDTO convertToDTO(Resultado resultado){
        return modelMapper.map(resultado, ResultadoResponseDTO.class);
    }

    public Resultado convertToEntity(ResultadoRequestDTO resultadoRequestDTO){
        return modelMapper.map(resultadoRequestDTO, Resultado.class);
    }

    public List<ResultadoResponseDTO> convertToListDTO(List<Resultado> resultados){
        return resultados.stream()
                .map(this::convertToDTO)
                .toList();
    }
}
