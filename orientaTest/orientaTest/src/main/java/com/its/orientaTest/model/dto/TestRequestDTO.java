package com.its.orientaTest.model.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class TestRequestDTO {
    private String tipoTest;
    private LocalDate fechaTest;
    private String estudianteId;
}