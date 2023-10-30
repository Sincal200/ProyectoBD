package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Cita;
import com.db.donaldapi.models.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Integer> {
    @Procedure
    Cita sp_LeerCita(Integer numeroCita);

    @Procedure
    void sp_CrearCita(Integer numeroCita,
                      Integer codigoSucursal,
                      Integer codigoCliente,
                      LocalDate fechaCita,
                      LocalDateTime fechaRecepcion,
                      String observaciones,
                      Integer codigoEmpleado,
                      Integer codigoAutomovil);

    @Procedure
    void sp_ActualizarCita(Integer numeroCita, String observaciones);

    @Procedure
    void sp_EliminarCita(Integer numeroCita);
}
