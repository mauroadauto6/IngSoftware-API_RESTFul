package com.its.orientaTest.service;

import com.its.orientaTest.repository.UniversidadRepository;
import com.its.orientaTest.model.dto.UniversidadResponseDTO;
import com.its.orientaTest.mapper.UniversidadMapper;
import com.its.orientaTest.model.entities.Universidad;
import com.its.orientaTest.exceptions.ResourceNotFoundException;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversidadService {
    private final UniversidadRepository universidadRepository;
    private final UniversidadMapper universidadMapper;

    @Transactional(readOnly = true)
    public List<UniversidadResponseDTO> getAllUniversidades(){
        List<Universidad> universidades = universidadRepository.findAll();
        return universidadMapper.convertToListDTO(universidades);
    }

    @Transactional(readOnly = true)
    public UniversidadResponseDTO getUniversidadById(Long id){
        Universidad universidad = universidadRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Universidad no encontrada con el numero:"+id));
        return universidadMapper.convertToDTO(universidad);
    }
}
