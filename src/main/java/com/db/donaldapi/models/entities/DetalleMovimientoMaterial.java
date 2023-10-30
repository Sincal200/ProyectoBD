package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DetalleMovimientoMaterial")
@Data
public class DetalleMovimientoMaterial {
    @Id
    private Integer NumeroMovimiento;
    private Integer CodigoMaterial;
    private Integer LineaDetalleMovimiento;
    private Integer Unidades;
}
