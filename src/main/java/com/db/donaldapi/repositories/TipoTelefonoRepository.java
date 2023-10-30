package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.TipoTelefono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface TipoTelefonoRepository extends JpaRepository<TipoTelefono, Integer> {
    //    CodigoTipoTelefono (smallint, PK)
    //    Descripcion (varchar(64))
    @Procedure
    List<TipoTelefono> spReadTiposTelefono();

    @Procedure
    void spCreateTipoTelefono(Integer codigoTipoTelefono,
                              String descripcion);

    @Procedure
    void spUpdateTipoTelefono(Integer codigoTipoTelefono,
                         String descripcion);

    @Procedure
    void spDeleteTipoTelefono(Integer codigoTipoTelefono);
}
