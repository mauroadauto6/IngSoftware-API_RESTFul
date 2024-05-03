package com.its.orientaTest.service;

import com.its.orientaTest.repository.ResultadoRepository;
import com.its.orientaTest.model.dto.ResultadoRequestDTO;
import com.its.orientaTest.model.dto.ResultadoResponseDTO;
import com.its.orientaTest.mapper.ResultadoMapper;
import com.its.orientaTest.repository.CarreraUniversidadRepository;
import com.its.orientaTest.model.entities.CarreraUniversidad;
import com.its.orientaTest.model.entities.Resultado;
import com.its.orientaTest.exceptions.ResourceNotFoundException;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ResultadoService {
    private final ResultadoRepository resultadoRepository;
    private final CarreraUniversidadRepository carreraUniversidadRepository;
    private final ResultadoMapper resultadoMapper;

    @Transactional(readOnly = true)
    public List<ResultadoResponseDTO> getAllResultados(){
        List<Resultado> resultados = resultadoRepository.findAll();
        return resultadoMapper.convertToListDTO(resultados);
    }

    @Transactional(readOnly = true)
    public ResultadoResponseDTO getResultadoById(Long id){
        Resultado resultado = resultadoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(("Resultado no encontrado con el numero:"+id)));
        return resultadoMapper.convertToDTO(resultado);
    }

    public ResultadoResponseDTO crearResultado(ResultadoRequestDTO resultadoRequestDTO) {
        Resultado resultado = resultadoMapper.convertToEntity(resultadoRequestDTO);
        
        Resultado universidadGuardada = resultadoRepository.save(resultado);

        return resultadoMapper.convertToDTO(universidadGuardada);
    }

    public CarreraUniversidad obtenerCarreraUniversidadAleatoria() {
        List<CarreraUniversidad> carreraUniversidades = carreraUniversidadRepository.findRandomRow();
        return carreraUniversidades.isEmpty() ? null : carreraUniversidades.get(0);
    }
}
