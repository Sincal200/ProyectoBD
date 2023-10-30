package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DetalleMaterial")
@Data
public class DetalleMaterial {
    @Id
    private Integer NumeroDetalleMaterial;
    private Integer NumeroOrden;
    private Integer NumeroManoDeObra;
    private Integer CodigoMaterial;
    private Integer Unidades;
    private Double PrecioVenta;
}
