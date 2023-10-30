package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Bodega")
@Data
public class Bodega {
//    CodigoSucursal
//            CodigoBodega
//    Descripcion
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CodigoBodega;
    private Integer CodigoSucursal;
    private String Descripcion;
}
