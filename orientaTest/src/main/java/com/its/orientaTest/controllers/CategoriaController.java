package com.its.orientaTest.controllers;
import com.its.orientaTest.model.dto.CategoriaRequestDTO;
import com.its.orientaTest.model.dto.CategoriaResponseDTO;
import com.its.orientaTest.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@AllArgsConstructor
public class CategoriaController {
private final CategoriaService categoriaService;
 @GetMapping
public ResponseEntity<List<CategoriaResponseDTO>> getAllCategoria(){
    List<CategoriaResponseDTO> categorias = categoriaService.getAllCategorias();
    return new ResponseEntity<>(categorias, HttpStatus.OK);
}

@GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> getCategoriaById(@PathVariable Long id){
    CategoriaResponseDTO categoria = categoriaService.getCategoriaById(id);
    return new ResponseEntity<>(categoria, HttpStatus.OK);
}

@PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> updateCategoria(@PathVariable Long id, @RequestBody CategoriaRequestDTO categoriaRequestDTO){
    CategoriaResponseDTO updateCategoria = categoriaService.updateCategoria(id,categoriaRequestDTO);
    return new ResponseEntity<>(updateCategoria, HttpStatus.NO_CONTENT);
}

@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id){
        categoriaService.deleteCategoria(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

}
