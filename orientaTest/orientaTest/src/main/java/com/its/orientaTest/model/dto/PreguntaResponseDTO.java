package com.its.orientaTest.model.dto;
import org.hibernate.mapping.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaResponseDTO {
    private Long id;
    private String Enunciado;
    //private CategoriaResponseDTO targetCategoria;
    private String nameCategoria;
}
