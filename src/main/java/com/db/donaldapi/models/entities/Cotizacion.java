package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Cotizacion")
@Data
public class Cotizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer NumeroCotizacion;
    private Integer NumeroRequisicion;
    private LocalDate FechaCotizacion;
    private Integer CodigoProveedor;
}
