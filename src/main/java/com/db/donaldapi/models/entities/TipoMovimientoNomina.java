package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TipoMovimientoNomina")
@Data
public class TipoMovimientoNomina {
//    CodigoTipoMovimientoNomina (smallint, PK)
//    Descripcion (varchar(128))
//    Naturaleza (smallint)
//    AfectoIGSS (bit)
//    AfectoISR (bit)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CodigoTipoMovimientoNomina;
    private String Descripcion;
    private Integer Naturaleza;
    private Boolean AfectoIGSS;
    private Boolean AfectoISR;
}
