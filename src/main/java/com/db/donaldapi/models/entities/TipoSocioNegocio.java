package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TipoSocioNegocio")
@Data
public class TipoSocioNegocio {
//    CodigoTipoSocioNegocio (int, PK)
//    Descripcion (varchar(30)
//    EsPersona (bit)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CodigoTipoSocioNegocio;
    private String Descripcion;
    private Boolean EsPersona;
}
