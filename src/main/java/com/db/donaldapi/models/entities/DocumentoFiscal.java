package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DocumentoFiscal")
@Data
public class DocumentoFiscal {
//    CodigoTipoDocumentoFiscal (int, PK)
//    Serie (varchar(3), PK)
//    Numero (int, PK)
//    FechaEmision (date)
//    NIT (varchar(50))
//    ValorTotal (money)
//    IVA (money)
//    Estado (varchar(50))
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CodigoTipoDocumentoFiscal;
    private String Serie;
    private Integer Numero;
    private LocalDate FechaEmision;
    private String NIT;
    private Double ValorTotal;
    private Double IVA;
    private String Estado;
}
