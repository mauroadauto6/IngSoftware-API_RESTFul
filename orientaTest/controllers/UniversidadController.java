package com.its.orientaTest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.its.orientaTest.model.dto.UniversidadResponseDTO;
import com.its.orientaTest.service.UniversidadService;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/universidades")
@AllArgsConstructor
public class UniversidadController {
    
    private final UniversidadService universidadService;

    @GetMapping
    public ResponseEntity<List<UniversidadResponseDTO>> getAllUniversidades(){
        List<UniversidadResponseDTO> universidades = universidadService.getAllUniversidades();
        return new ResponseEntity<>(universidades, HttpStatus.OK);
    }
    
    //http://localhost:8080/api/v1/universidades/2
    @GetMapping("/{id}")
    public ResponseEntity<UniversidadResponseDTO> getUniversidadById(@PathVariable Long id) {
        UniversidadResponseDTO universidad = universidadService.getUniversidadById(id);
        return new ResponseEntity<>(universidad, HttpStatus.OK);
    }

}
