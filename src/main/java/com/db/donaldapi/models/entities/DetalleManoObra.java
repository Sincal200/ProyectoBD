package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "DetalleManoObra")
@Data
public class DetalleManoObra {
    @Id
    private Integer NumeroManoDeObra;
    private Integer NumeroOrden;
    private Integer Unidades;
    private Integer CodigoManoObra;
    private LocalDateTime FechaInicio;
    private LocalDateTime FechaFin;
    private Integer CodigoEmpleado;
    private String Serie;
    private Integer Numero;
    private Integer CodigoTipoDocumentoFiscal;
}
