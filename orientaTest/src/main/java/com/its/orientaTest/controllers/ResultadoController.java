package com.its.orientaTest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import com.its.orientaTest.model.dto.ResultadoResponseDTO;
=======
import com.its.orientaTest.model.dto.ResultadoRequestDTO;
import com.its.orientaTest.model.dto.ResultadoResponseDTO;
import com.its.orientaTest.model.entities.CarreraUniversidad;
>>>>>>> 6a399027ef3bf553783515118d3584244f644b54
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
<<<<<<< HEAD
=======

    @GetMapping("/random")
    public ResponseEntity<CarreraUniversidad> obtenerResultadoAleatorio() {
        CarreraUniversidad carreraUniversidad = resultadoService.obtenerCarreraUniversidadAleatoria();
        if (carreraUniversidad != null) {
            return ResponseEntity.ok(carreraUniversidad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ResultadoResponseDTO> crearResultado(@RequestBody ResultadoRequestDTO resultadoRequestDTO) {
        ResultadoResponseDTO resultadoCreado = resultadoService.crearResultado(resultadoRequestDTO);
        return ResponseEntity.ok(resultadoCreado);
    }
>>>>>>> 6a399027ef3bf553783515118d3584244f644b54
}
