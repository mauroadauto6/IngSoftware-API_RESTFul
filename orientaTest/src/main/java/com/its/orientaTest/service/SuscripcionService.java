package com.its.orientaTest.service;

import com.its.orientaTest.exception.ResourceNotFoundException;
import com.its.orientaTest.model.entities.Estudiante;
import com.its.orientaTest.model.entities.Suscripcion;
import com.its.orientaTest.repository.EstudianteRepository;

public class SuscripcionService {

    private final SubscripcionRepository subscripcionRepository;

    private final EstudianteRepository estudianteRepository;

    private final SubscripcionMapper subscripcionMapper;
    publica SubscripcionResponseDTO registroSubscripcion(SubscripcionRequestDTO subscripcionRequestDTO){

            Estudiante estudiante= estudianteRepository.findById(subscripcionRequestDTO.getIdEstudiante())
                    .orElseThrow(()->new ResourceNotFoundException("El estudiante no existe"));

            Suscripcion subscripcion = subscripcionMapper.converToEntity(subscripcionRequestDTO, subscripcion.class);

            subscripcion.setEstudiante(estudiante);

            subscripcionRepository.save(subscripcion);

             return subscripcionMapper.converToDTO(subscripcion, SubscripcionResponseDTO.class);

    }
}
