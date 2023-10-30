package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Marca")
@Data
public class Marca {
//    CodigoMarca (int, PK)
//    Descripcion (varchar(30))

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CodigoMarca;
    private String Descripcion;
}
