package com.db.donaldapi.models.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateAsistenciaDto {
    private Integer correlativoAsistencia;
    private Integer codigoEmpleado;
    private LocalDateTime fechaEgreso;
}
