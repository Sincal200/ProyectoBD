package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "DetalleCotizacion")
@Data
public class DetalleCotizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer LineaCotizacion;
    private Integer NumeroRequisicion;
    private Integer NumeroCotizacion;
    private Integer CodigoMaterial;
    private Integer Unidades;
    private Integer PrecioCompra;
}
