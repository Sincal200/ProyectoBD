package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
    @Procedure
    List<Sucursal> spReadSucursales();

    @Procedure
    void spCreateSucursal(Integer codigoSucursal,
                          String nombreSucursal,
                          Integer codigoTaller);

    @Procedure
    void spUpdateSucursal(Integer codigoSucursal,
                          String nombreSucursal,
                          Integer codigoTaller);

    @Procedure
    void spDeleteSucursal(Integer codigoSucursal);
}
