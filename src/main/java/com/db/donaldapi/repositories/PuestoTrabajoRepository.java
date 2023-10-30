package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.PuestoTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface PuestoTrabajoRepository extends JpaRepository<PuestoTrabajo, Integer> {
    @Procedure
    List<PuestoTrabajo> usp_GetPuestoTrabajo();

    @Procedure
    void usp_CretePuestoTrabajo(Integer CodigoPuesto, String descripcion);

    @Procedure
    void usp_UpdatePuestoTrabajo(Integer Id, String descripcion);

    @Procedure
    void usp_DetletePuestoTrabajo(Integer Id);
}
