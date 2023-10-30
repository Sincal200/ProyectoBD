package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ContratoTrabajo")
@Data
public class ContratoTrabajo {
//    FechaEmision
//            Estado
//    CodigoTaller
//            CodigoEmpleado
//    NumeroContrato
//            CodigoDepartamentoTrabajo
//    CodigoPuestoTrabajo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer NumeroContrato;
    private LocalDate FechaEmision;
    private String Estado;
    private Integer CodigoTaller;
    private Integer CodigoEmpleado;
    private Integer CodigoDepartamentoTrabajo;
    private Integer CodigoPuestoTrabajo;


}
