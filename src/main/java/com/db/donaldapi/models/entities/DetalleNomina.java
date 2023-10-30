package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DetalleNomina")
@Data
public class DetalleNomina {
    @Id
    private Integer NumeroDetalleNomina;
    private Integer CodigoNomina;
    private Integer CodigoTipoMovimientoNomina;
    private Double Valor;
    private Integer CodigoEmpleado;
    private Integer CodigoSucursal;
}
