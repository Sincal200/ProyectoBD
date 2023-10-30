package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Automovil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface AutomovilRepository extends JpaRepository<Automovil, Integer> {
    @Procedure
    Automovil sp_LeerAutomovil(Integer codigoAutomovil);

    @Procedure
    void sp_CrearAutomovil(Integer codigoAutomovil,
                           String placa,
                           String color,
                           String vin,
                           String motor,
                           Integer modelo,
                           Integer codigoModelo,
                           Integer codigoMarca);

    @Procedure
    void sp_ActualizarAutomovil(Integer codigoAutomovil,
                                String color);

    @Procedure
    void sp_BorrarAutomovil(Integer codigoAutomovil);
}
