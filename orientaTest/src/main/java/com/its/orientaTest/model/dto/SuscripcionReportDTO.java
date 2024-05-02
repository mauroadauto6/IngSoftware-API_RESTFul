package com.its.orientaTest.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class SuscripcionReportDTO {
    private LocalDate date;
    private long SuscriptionCount;
}


