package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.OrdenDeTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.time.LocalDate;
import java.util.List;

public interface OrdenDeTrabajoRepository extends JpaRepository<OrdenDeTrabajo, Integer> {
    //    NumeroOrden (int, PK)
//    FechaOrden (date)
//    Estado (varchar(35))
//    NumeroCita (int)
    @Procedure
    List<OrdenDeTrabajo> usp_GetOrdenesDeTrabajo();

    @Procedure
    void usp_CreateOrdenDeTrabajo(Integer numeroOrden,
                                  LocalDate fechaOrden,
                                  String estado,
                                  Integer numeroCita);

    @Procedure
    void usp_UpdateOrdenDeTrabajo(Integer numeroOrden,
                                  LocalDate fechaOrden,
                                  String estado,
                                  Integer numeroCita);

    @Procedure
    void usp_DeleteOrdenDeTrabajo(Integer numeroOrden);
}
