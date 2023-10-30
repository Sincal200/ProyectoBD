package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "SocioNegocio")
@Data
public class SocioNegocio {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer CodigoSocio;
    private String PrimerNombre;
    private String SegundoNombre;
    private String PrimerApellido;
    private String SegundoApellido;
    private LocalDate FechaNacimiento;
    private String CUI;
    private String NIT;
    private String RazonSocial;
    private String Genero;
    private Integer CodigoTipoSocioNegocio;
}
