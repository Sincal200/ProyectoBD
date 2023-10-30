package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.ContratoTrabajo;
import com.db.donaldapi.models.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.time.LocalDate;
import java.util.List;

public interface ContratoTrabajoRepository extends JpaRepository<ContratoTrabajo, Integer> {
    @Procedure
    ContratoTrabajo sp_LeerContratoTrabajo(Integer numeroContrato,
                                           Integer codigoTaller,
                                           Integer codigoEmpleado);

    @Procedure
    void sp_CrearContratoTrabajo(LocalDate fechaEmision,
                                 String estado,
                                 Integer codigoTaller,
                                 Integer codigoEmpleado,
                                 Integer numeroContrato,
                                 Integer codigoDepartamentoTrabajo,
                                 Integer codigoPuestoTrabajo);

    @Procedure
    void sp_ActualizarContratoTrabajo(Integer numeroContrato,
                                      Integer codigoTaller,
                                      Integer codigoEmpleado,
                                      String estado);

    @Procedure
    void sp_EliminarContratoTrabajo(Integer numeroContrato,
                                    Integer codigoTaller,
                                    Integer codigoEmpleado);
}
