package com.db.donaldapi.models.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateCotizacionDto {
    private Integer numeroRequisicion;
    private Integer numeroCotizacion;
    private LocalDate fechaCotizacion;
}
