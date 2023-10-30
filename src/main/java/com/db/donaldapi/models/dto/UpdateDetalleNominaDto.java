package com.db.donaldapi.models.dto;

import lombok.Data;

@Data
public class UpdateDetalleNominaDto {
    private Integer codigoNomina;
    private Integer numeroDetalleNomina;
    private Double valor;
}
