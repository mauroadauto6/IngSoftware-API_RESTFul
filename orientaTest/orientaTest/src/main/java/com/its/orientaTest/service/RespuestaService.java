package com.its.orientaTest.service;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.its.orientaTest.exceptions.ResourceNotFoundException;
import com.its.orientaTest.mapper.RespuestaMapper;
import com.its.orientaTest.model.dto.RespuestaRequestDTO;
import com.its.orientaTest.model.dto.RespuestaResponseDTO;
import com.its.orientaTest.model.entities.Respuesta;
import com.its.orientaTest.repository.RespuestaRepository;

@Service
@AllArgsConstructor

public class RespuestaService {

    private final RespuestaRepository respuestaRepository;
    private final RespuestaMapper respuestaMapper;
    
    @Transactional
    public RespuestaResponseDTO guardarRespuesta(RespuestaRequestDTO respuestaRequestDTO) {
        Respuesta respuesta = respuestaMapper.convertToEntity(respuestaRequestDTO);
        respuestaRepository.save(respuesta);
        return respuestaMapper.convertToDTO(respuesta);
    }

    @Transactional
    public RespuestaResponseDTO validarRespuesta(Long id, RespuestaRequestDTO respuestaRequestDTO) {
        Respuesta respuesta = respuestaRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Respuesta no encontrada con el numero:" + id));

        respuesta.setValor(respuestaRequestDTO.getValor());

        respuestaRepository.save(respuesta);

        return respuestaMapper.convertToDTO(respuesta);
    }

    @Transactional(readOnly = true)
    public List<RespuestaResponseDTO> obtenerTodasLasRespuestas() {
        List<Respuesta> respuestas = respuestaRepository.findAll();
        return respuestaMapper.convertToListDTO(respuestas);
    }

    @Transactional(readOnly = true)
    public RespuestaResponseDTO obtenerRespuestaPorId(Long id) {
        Respuesta respuesta = respuestaRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Respuesta no encontrada con el numero:"+id));
        return respuestaMapper.convertToDTO(respuesta);
    }
}
