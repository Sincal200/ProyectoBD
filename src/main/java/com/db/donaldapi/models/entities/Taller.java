package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Taller")
@Data
public class Taller {
//    CodigoTaller (int, PK)
//    RazonSocial (varchar(60))
//    NombreComercial (varchar(60))
//    NIT (varchar(20))
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CodigoTaller;
    private String RazonSocial;
    private String NombreComercial;
    private String NIT;
}
