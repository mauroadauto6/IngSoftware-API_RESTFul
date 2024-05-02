package com.its.orientaTest.service;


import com.its.orientaTest.exception.ResourceNotFoundException;
import com.its.orientaTest.mapper.PreguntaMapper;
import com.its.orientaTest.model.dto.PreguntaRequestDTO;
import com.its.orientaTest.model.dto.PreguntaResponseDTO;
import com.its.orientaTest.model.entities.Pregunta;
import com.its.orientaTest.repository.PreguntaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PreguntaService {
    private final PreguntaRepository preguntaRepository;
    private final PreguntaMapper preguntaMapper;


    public PreguntaService(PreguntaRepository preguntaRepository, PreguntaMapper preguntaMapper) {
        this.preguntaRepository = preguntaRepository;
        this.preguntaMapper = preguntaMapper;
    }

    @Transactional(readOnly = true)
    public List<PreguntaResponseDTO> getAllPreguntas(){
        List<Pregunta> preguntas = preguntaRepository.findAll();
        return preguntaMapper.convertToListDTO(preguntas);
    }

    @Transactional(readOnly = true)
    public PreguntaResponseDTO getpreguntaaById(Long id){
        Pregunta pregunta = preguntaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pregunta no encontrada"));
        return preguntaMapper.convertToDTO((pregunta));
    }

    @Transactional
    public PreguntaResponseDTO updatePregunta(Long id, PreguntaRequestDTO preguntaRequestDTO){
        Pregunta pregunta = preguntaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pregunta no encontrada con el numero: " +id));
        pregunta.setnombre(preguntaRequestDTO.getnombre());
        pregunta = PreguntaRepository.save(pregunta);
        return preguntaMapper.convertToDTO(pregunta);
    }
    @Transactional
    public void deletePregunta (Long id){
        preguntaRepository.deleteById(id);
    }

}
