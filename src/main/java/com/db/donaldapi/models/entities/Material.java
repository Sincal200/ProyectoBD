package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Material")
@Data
public class Material {
//    CodigoMaterial (int, PK)
//    Descripcion (varchar(60))
//    PrecioCosto (money)
//    PrecioVenta (money)
//    Saldo (numeric(14,4))
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CodigoMaterial;
    private String Descripcion;
    private Double PrecioCosto;
    private Double PrecioVenta;
    private Double Saldo;
}
