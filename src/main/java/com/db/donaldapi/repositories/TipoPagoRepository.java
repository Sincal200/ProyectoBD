package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface TipoPagoRepository extends JpaRepository<TipoPago, Integer> {
    //    CodigoTipoPago (int, PK)
    //    Descripcion (varchar(50))
    @Procedure
    List<TipoPago> spReadTiposPago();

    @Procedure
    void spCreateTipoPago(Integer codigoTipoPago, String descripcion);

    @Procedure
    void spUpdateTipoPago(Integer codigoTipoPago, String descripcion);

    @Procedure
    void spDeleteTipoPago(Integer codigoTipoPago);
}
