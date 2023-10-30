package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PuestoTrabajo")
@Data
public class PuestoTrabajo {
//    CodigoPuestoTrabajo (smallint, PK)
//    Descripcion (varchar(128))
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CodigoPuestoTrabajo;
    private String Descripcion;
}
