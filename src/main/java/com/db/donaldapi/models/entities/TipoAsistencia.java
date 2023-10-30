package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TipoAsistencia")
@Data
public class TipoAsistencia {
//    CodigoTipoAsistencia (smallint, PK)
//    Descripcion (varchar(60))
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CodigoTipoAsistencia;
    private String Descripcion;
}
