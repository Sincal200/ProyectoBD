package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {
    @Procedure
    List<Marca> usp_GetMarcas();

    @Procedure
    void usp_CreateMarca(Integer codigoMarca, String descripcion);

    @Procedure
    void usp_UpdateMarca(Integer codigoMarca, String descripcion);

    @Procedure
    void usp_DeleteMarca(Integer codigoMarca);
}
