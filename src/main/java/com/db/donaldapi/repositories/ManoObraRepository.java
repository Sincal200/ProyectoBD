package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Departamento;
import com.db.donaldapi.models.entities.ManoObra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface ManoObraRepository extends JpaRepository<ManoObra, Integer> {

//    CodigoManoObra (int, PK)
//    Descripcion (varchar(30))
//    Precio (money)
    @Procedure
    ManoObra spLeerManoObra(Integer codigoManoObra);

    @Procedure
    void spCrearManoObra(Integer codigoManoObra,
                         String descripcion,
                         Double precio);

    @Procedure
    void spEliminarManoObra(Integer codigoManoObra);

    @Procedure
    void spActualizarManoObra(Integer codigoManoObra,
                              String descripcion,
                              Double precio);
}
