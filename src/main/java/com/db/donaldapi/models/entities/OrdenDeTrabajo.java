package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "OrdenDeTrabajo")
@Data
public class OrdenDeTrabajo {
//    NumeroOrden (int, PK)
//    FechaOrden (date)
//    Estado (varchar(35))
//    NumeroCita (int)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer NumeroOrden;
    private LocalDate FechaOrden;
    private String Estado;
    private Integer NumeroCita;
}
