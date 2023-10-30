package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Bodega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface BodegaRepository extends JpaRepository<Bodega, Integer> {
    @Procedure
    Bodega sp_LeerBodega(Integer codigoSucursal,
                         Integer codigoBodega);

    @Procedure
    void sp_CrearBodega(Integer codigoSucursal,
                         Integer codigoBodega,
                         String descripcion);

    @Procedure
    void sp_ActualizarBodega(Integer codigoSucursal,
                             Integer codigoBodega,
                             String descripcion);

    @Procedure
    void sp_EliminarBodega(Integer codigoSucursal,
                           Integer codigoBodega);
}
