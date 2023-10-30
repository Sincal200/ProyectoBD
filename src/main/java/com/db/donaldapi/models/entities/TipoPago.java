package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TipoPago")
@Data
public class TipoPago {
//    CodigoTipoPago (int, PK)
//    Descripcion (varchar(50))
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CodigoTipoPago;
    private String Descripcion;
}
