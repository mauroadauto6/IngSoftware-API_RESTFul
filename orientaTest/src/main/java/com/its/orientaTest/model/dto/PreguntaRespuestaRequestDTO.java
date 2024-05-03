package com.its.orientaTest.model.dto;
import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaRespuestaRequestDTO{
    @NotBlank(message = "Debe incluir un enunciado")
    private String Enunciado;
    @NotNull(message = "Debe de contener un id_categoria")
    private Long idCategoria;
    @NotBlank(message = "Debe de incluir una lista de resultados")
    private List<RespuestaResponseDTO> Resultado;
}
