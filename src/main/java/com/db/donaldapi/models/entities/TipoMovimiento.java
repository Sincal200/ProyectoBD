package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TipoMovimiento")
@Data
public class TipoMovimiento {
//    CodigoTipoMovimiento (int, PK)
//    Descripcion (varchar(60))
//    Naturaleza (tinyint)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CodigoTipoMovimiento;
    private String Descripcion;
    private Integer Naturaleza;
}
