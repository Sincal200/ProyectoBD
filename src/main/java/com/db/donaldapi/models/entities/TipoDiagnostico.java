package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TipoDiagnostico")
@Data
public class TipoDiagnostico {
//    CodigoDiagnostico (int, PK)
//    Descripcion (varchar(60))
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CodigoDiagnostico;
    private String Descripcion;
}
