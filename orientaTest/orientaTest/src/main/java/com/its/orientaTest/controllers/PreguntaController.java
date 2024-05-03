package com.its.orientaTest.controllers;
import com.its.orientaTest.model.dto.PreguntaRequestDTO;
import com.its.orientaTest.model.dto.PreguntaResponseDTO;
import com.its.orientaTest.service.PreguntaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preguntas")
@AllArgsConstructor

public class PreguntaController {
    private final PreguntaService preguntaService;
    @GetMapping
    public ResponseEntity<List<PreguntaResponseDTO>> getAllPreguntas(){
        List<PreguntaResponseDTO> preguntas = preguntaService.getAllPreguntas();
        return new ResponseEntity<>(preguntas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreguntaResponseDTO> getPreguntaById(@PathVariable Long id){
        PreguntaResponseDTO pregunta = preguntaService.getpreguntaaById(id);
        return new ResponseEntity<>(pregunta, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PreguntaResponseDTO> updatePregunta(@PathVariable Long id, @RequestBody PreguntaRequestDTO preguntaRequestDTO){
        PreguntaResponseDTO updatePregunta = preguntaService.updatePregunta(id,preguntaRequestDTO);
        return new ResponseEntity<>(updatePregunta, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id){
        preguntaService.deletePregunta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
