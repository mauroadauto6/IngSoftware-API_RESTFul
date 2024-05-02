package com.its.orientaTest.service;

import com.its.orientaTest.exceptions.ResourceNotFoundException;
import com.its.orientaTest.mapper.CategoriaMapper;
import com.its.orientaTest.model.dto.CategoriaRequestDTO;
import com.its.orientaTest.model.dto.CategoriaResponseDTO;
import com.its.orientaTest.model.entities.Categoria;
import com.its.orientaTest.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;
    @Transactional(readOnly = true)
    public List<CategoriaResponseDTO> getAllCategorias(){
        List<Categoria> categorias = categoriaRepository.findAll();
        return categoriaMapper.convertToListDTO(categorias);
    }

    @Transactional(readOnly = true)
    public CategoriaResponseDTO  getCategoriaById(Long id){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Categoria no encontrada"));
        return categoriaMapper.convertToDTO((categoria));
    }

    @Transactional
    public CategoriaResponseDTO updateCategoria(Long id, CategoriaRequestDTO categoriaRequestDTO){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Categoria no encontrada con el numero: " +id));
        categoria.setNombre(categoriaRequestDTO.getNombre());
        categoria = categoriaRepository.save(categoria);
        return categoriaMapper.convertToDTO(categoria);
    }

    public void deleteCategoria (Long id){
        categoriaRepository.deleteById(id);
    }


}
