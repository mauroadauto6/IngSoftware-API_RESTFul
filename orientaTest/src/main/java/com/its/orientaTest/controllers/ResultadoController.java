package com.its.orientaTest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.its.orientaTest.model.dto.ResultadoResponseDTO;
import com.its.orientaTest.service.ResultadoService;
import lombok.AllArgsConstructor;

import java.util.List;


@RestController
@RequestMapping("/resultados")
@AllArgsConstructor
public class ResultadoController {

    private final ResultadoService resultadoService;

    @GetMapping
    public ResponseEntity<List<ResultadoResponseDTO>> getAllResultados(){
        List<ResultadoResponseDTO> resultados = resultadoService.getAllResultados();
        return new ResponseEntity<>(resultados, HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/resultados/11
    @GetMapping("/{id}")
    public ResponseEntity<ResultadoResponseDTO> getUniversidadById(@PathVariable Long id) {
        ResultadoResponseDTO resultado = resultadoService.getResultadoById(id);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}