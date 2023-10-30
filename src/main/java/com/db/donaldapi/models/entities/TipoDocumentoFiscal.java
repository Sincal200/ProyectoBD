package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TipoDocumentoFiscal")
@Data
public class TipoDocumentoFiscal {
//    CodigoTipoDocumentoFiscal (int, PK)
//    Descripcion (varchar(50))
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CodigoTipoDocumentoFiscal;
    private String Descripcion;
}
