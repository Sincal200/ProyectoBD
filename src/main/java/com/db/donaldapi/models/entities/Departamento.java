package com.db.donaldapi.models.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Departamento")
@Getter @Setter
@ToString
public class Departamento {
    @Id
    @Column(name = "CodigoDepartamento")
    private Integer codigoDepartamento;
    @Column(name = "Descripcion")
    private String descripcion;
}
