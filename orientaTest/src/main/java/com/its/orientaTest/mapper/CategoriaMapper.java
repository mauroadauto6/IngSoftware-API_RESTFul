package com.its.orientaTest.mapper;
import com.its.orientaTest.model.dto.CategoriaRequestDTO;
import com.its.orientaTest.model.dto.CategoriaResponseDTO;
import com.its.orientaTest.model.entities.Categoria;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@AllArgsConstructor
@Component
public class CategoriaMapper {

    private final ModelMapper modelMapper;
    public Categoria convertToEntity(CategoriaRequestDTO categoriaRequestDTO){
        return modelMapper.map(categoriaRequestDTO, Categoria.class);
    }
    public CategoriaResponseDTO convertToDTO(Categoria categoria){
        return modelMapper.map(categoria, CategoriaResponseDTO.class);
    }
    public List<CategoriaResponseDTO> convertToListDTO(List<Categoria> categorias){
        return categorias.stream().map(this::convertToDTO).toList();
    }
}
