package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Municipio")
@Data
public class Municipio {
//    CodigoMunicipio (smallint, PK)
//    DepartamentoCodigo (smallint, PK)
//    Descripcion (varchar(64))
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CodigoMunicipio;

    @Column()
    private String Departamento;
    private String Descripcion;
}
