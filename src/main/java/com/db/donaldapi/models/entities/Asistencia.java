package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Asistencia")
@Data
public class Asistencia {
//    CorrelativoAsistencia
//            CodigoEmpleado
//    CodigoTipoAsistencia
//            FechaIngreso
//    FechaEgreso
//            Origen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CorrelativoAsistencia;
    private Integer CodigoEmpleado;
    private Integer CodigoTipoAsistencia;
    private LocalDateTime FechaIngreso;
    private LocalDateTime FechaEgreso;
    private String Origen;
}
