package com.its.orientaTest.mapper;

import com.its.orientaTest.model.dto.EstudianteRequestDTO;
import com.its.orientaTest.model.dto.EstudianteResponseDTO;
import com.its.orientaTest.model.entities.Estudiante;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

//notacion cuando una clase no cumple las siguiente responsabilidades, configuracion, service, rest controller o entity
@Component
@AllArgsConstructor
public class EstudianteMapper {
    private final ModelMapper modelMapper;
    //Se puede hacer un constructor o uso de lumbo
    public Estudiante convertToEntity(EstudianteRequestDTO estudianteRequestDTO){
        return modelMapper.map(estudianteRequestDTO, Estudiante.class);
    }

    public EstudianteResponseDTO convertToDTO(Estudiante estudiante){
        return modelMapper.map(estudiante, EstudianteResponseDTO.class);
    }

    public List<EstudianteResponseDTO> convertToDTO(List<Estudiante> Estudiantes){
        return Estudiantes.stream().map(this::convertToDTO).toList();
    }


}
