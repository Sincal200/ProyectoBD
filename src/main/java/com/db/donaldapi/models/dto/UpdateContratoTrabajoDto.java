package com.db.donaldapi.models.dto;

import lombok.Data;

@Data
public class UpdateContratoTrabajoDto {
    private Integer numeroContrato;
    private Integer codigoTaller;
    private Integer codigoEmpleado;
    private String estado;
}
