package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Sucursal")
@Data
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CodigoSucursal;
    private String NombreSucursal;
    private Integer CodigoTaller;
}
