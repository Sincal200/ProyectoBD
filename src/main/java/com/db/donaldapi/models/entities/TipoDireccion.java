package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TipoDireccion")
@Data
public class TipoDireccion {
//    CodigoTipoDireccion (smallint, PK)
//    Descripcion (varchar(64))
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CodigoTipoDireccion;
    private String Descripcion;
}
