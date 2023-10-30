package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Automovil")
@Data
public class Automovil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CodigoAutomovil;
    private String Placa;
    private String Color;
    private String VIN;
    private String Motor;
    private Integer Modelo;
    private Integer CodigoModelo;
    private Integer CodigoMarca;
}
