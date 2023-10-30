package com.db.donaldapi.models.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateDetalleManoObraDto {
    private Integer numeroOrden;
    private Integer  numeroManoDeObra;
    private Integer unidades;
    private Integer codigoManoObra;
    private LocalDateTime fechaFin;
}
