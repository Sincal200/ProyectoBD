package com.db.donaldapi.models.dto;

import lombok.Data;

@Data
public class UpdateDetalleMovimientoMaterialDto {
    private Integer NumeroMovimiento;
    private Integer LineaDetalleMovimiento;
    private Integer Unidades;
}
