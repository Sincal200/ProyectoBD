package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.DetalleMaterial;
import com.db.donaldapi.models.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface DetalleMaterialRepository extends JpaRepository<DetalleMaterial, Integer> {
    @Procedure
    List<DetalleMaterial> sp_leer_detalles_material();

    @Procedure
    void sp_insertar_detalle_material(Integer numeroOrden,
                                      Integer numeroManoDeObra,
                                      Integer codigoMaterial,
                                      Integer numeroDetalleMaterial,
                                      Integer unidades,
                                      Double precioVenta);
    @Procedure
    void sp_actualizar_detalle_material(Integer numeroOrden,
                                        Integer numeroManoDeObra,
                                        Integer numeroDetalleMaterial,
                                        Integer unidades,
                                        Double precioVenta);
    @Procedure
    void sp_eliminar_detalle_material(Integer numeroOrden,
                                      Integer numeroManoDeObra,
                                      Integer numeroDetalleMaterial);
}
