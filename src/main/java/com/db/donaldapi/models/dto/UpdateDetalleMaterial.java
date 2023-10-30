package com.db.donaldapi.models.dto;

import lombok.Data;

@Data
public class UpdateDetalleMaterial {
    private Integer numeroOrden;
    private Integer numeroManoDeObra;
    private Integer numeroDetalleMaterial;
    private Integer unidades;
    private Double precioVenta;
}
