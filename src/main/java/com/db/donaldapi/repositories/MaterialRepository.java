package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
    //    CodigoMaterial (int, PK)
    //    Descripcion (varchar(60))
    //    PrecioVenta (money)
    //    PrecioCosto (money)
    //    Saldo (numeric(14,4))
    @Procedure
    List<Material> usp_GetMateriales();

    @Procedure
    void usp_CreateMaterial(Integer codigoMaterial,
                            String descripcion,
                            Double precioVenta,
                            Double precioCosto,
                            Double saldo);

    @Procedure
    void usp_UpdateMaterial(Integer codigoMaterial,
                            String descripcion,
                            Double precioVenta,
                            Double precioCosto,
                            Double saldo);
    @Procedure
    void usp_DeleteMaterial(Integer codigoMaterial);
}
