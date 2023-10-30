package com.db.donaldapi.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ManoObra")
@Data
public class ManoObra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CodigoManoObra;
    private String Descripcion;
    private Double Precio;
}
