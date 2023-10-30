package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Cita")
@Data
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer NumeroCita;
    private Integer CodigoSucursal;
    private Integer CodigoCliente;
    private LocalDate FechaCita;
    private LocalDateTime FechaRecepcion;
    private String Observaciones;
    private Integer CodigoEmpleado;
    private Integer CodigoAutomovil;
}
