package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.DetalleMovimientoMaterial;
import com.db.donaldapi.models.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface DetalleMovimientoMaterialRepository extends JpaRepository<DetalleMovimientoMaterial, Integer> {
    @Procedure
    List<DetalleMovimientoMaterial> sp_leer_detalles_movimientos_material();

    @Procedure
    void sp_insertar_detalle_movimiento_material(Integer numeroMovimiento,
                                                 Integer codigoMaterial,
                                                 Integer lineaDetalleMovimiento,
                                                 Integer unidades);
    @Procedure
    void sp_actualizar_detalle_movimiento_material(Integer NumeroMovimiento,
                                                     Integer LineaDetalleMovimiento,
                                                     Integer Unidades);

    @Procedure
    void sp_eliminar_detalle_movimiento_material(Integer NumeroMovimiento,
                                                Integer LineaDetalleMovimiento);
}
