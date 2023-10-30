package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TipoTelefono")
@Data
public class TipoTelefono {
//    CodigoTipoTelefono (smallint, PK)
//    Descripcion (varchar(64))
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CodigoTipoTelefono;
    private String Descripcion;
}
