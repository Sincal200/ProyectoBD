package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.DetalleManoObra;
import com.db.donaldapi.models.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface DetalleManoObraRepository extends JpaRepository<DetalleManoObra, Integer> {
    @Procedure
    List<DetalleManoObra> sp_leer_detalles_mano_obra();

    @Procedure
    void sp_insertar_detalle_mano_obra(Integer numeroOrden,
                                       Integer  numeroManoDeObra,
                                       Integer unidades,
                                       Integer codigoManoObra,
                                       LocalDateTime fechaInicio,
                                       LocalDateTime fechaFin,
                                       Integer codigoEmpleado,
                                       String serie,
                                       Integer numero,
                                       Integer codigoTipoDocumentoFiscal);

    @Procedure
    void sp_actualizar_detalle_mano_obra(Integer numeroOrden,
                                         Integer  numeroManoDeObra,
                                         Integer unidades,
                                         Integer codigoManoObra,
                                         LocalDateTime fechaFin);

    @Procedure
    void sp_eliminar_detalle_mano_obra(Integer numeroOrden,
                                    Integer  numeroManoDeObra);
}
