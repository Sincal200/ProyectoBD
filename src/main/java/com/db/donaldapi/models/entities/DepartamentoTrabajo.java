package com.db.donaldapi.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "DepartamentoTrabajo")
@Entity
@NoArgsConstructor @AllArgsConstructor
public class DepartamentoTrabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodigoDepartamentoTrabajo")
    private Integer codigoDepartamentoTrabajo;
    @Column(name = "Descripcion")
    private String descripcion;
}
