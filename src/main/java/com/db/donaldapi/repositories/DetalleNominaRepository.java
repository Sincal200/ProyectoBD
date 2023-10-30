package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.DetalleNomina;
import com.db.donaldapi.models.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface DetalleNominaRepository extends JpaRepository<DetalleNomina, Integer> {
    @Procedure
    List<DetalleNomina> sp_leer_detalles_nomina();

    @Procedure
    void sp_insertar_detalle_nomina(Integer codigoNomina,
                                    Integer numeroDetalleNomina,
                                    Integer codigoTipoMovimientoNomina,
                                    Double valor,
                                    Integer codigoEmpleado,
                                    Integer codigoSucursal);

    @Procedure
    void sp_actualizar_detalle_nomina(Integer codigoNomina,
                                      Integer numeroDetalleNomina,
                                      Double valor);
    @Procedure
    void sp_eliminar_detalle_nomina(Integer codigoNomina,
                                    Integer numeroDetalleNomina);
}
