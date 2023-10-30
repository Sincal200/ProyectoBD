package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Cotizacion;
import com.db.donaldapi.models.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.time.LocalDate;
import java.util.List;

public interface CotizaciónRepository extends JpaRepository<Cotizacion, Integer> {
    @Procedure
    Cotizacion sp_LeerCotizacion(Integer numeroRequisicion,
                                 Integer numeroCotizacion);

    @Procedure
    void sp_CrearCotizacion(Integer numeroRequisicion,
                            Integer numeroCotizacion,
                            LocalDate fechaCotizacion,
                            Integer codigoProveedor);

    @Procedure
    void sp_ActualizarCotizacion(Integer numeroRequisicion,
                                 Integer numeroCotizacion,
                                 LocalDate fechaCotizacion);

    @Procedure
    void sp_EliminarCotizacion(Integer numeroRequisicion,
                               Integer numeroCotizacion);
}
