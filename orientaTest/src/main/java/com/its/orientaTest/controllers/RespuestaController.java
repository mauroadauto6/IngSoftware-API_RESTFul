package com.its.orientaTest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.its.orientaTest.model.dto.RespuestaRequestDTO;
import com.its.orientaTest.model.dto.RespuestaResponseDTO;
import com.its.orientaTest.service.RespuestaService;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/respuestas")
@AllArgsConstructor
public class RespuestaController {
    private final RespuestaService respuestaService;

    @GetMapping
    public ResponseEntity<List<RespuestaResponseDTO>> getAllRespuestas() {
        List<RespuestaResponseDTO> respuestas = respuestaService.obtenerTodasLasRespuestas();
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaResponseDTO> getRespuestaById(@PathVariable Long id) {
        RespuestaResponseDTO respuesta = respuestaService.obtenerRespuestaPorId(id);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping
    public ResponseEntity<RespuestaResponseDTO> saveRespuesta(@Validated @RequestBody
                                                                RespuestaRequestDTO respuestaDTO) {
        RespuestaResponseDTO saveRespuesta = respuestaService.guardarRespuesta(respuestaDTO);
        return new ResponseEntity<>(saveRespuesta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespuestaResponseDTO> validateRespuesta(@PathVariable Long id, @Validated @RequestBody RespuestaRequestDTO respuestaDTO) {
        RespuestaResponseDTO validateRespuesta = respuestaService.validarRespuesta(id, respuestaDTO);
        return new ResponseEntity<>(validateRespuesta, HttpStatus.OK);                                                                            
    }
        
}
