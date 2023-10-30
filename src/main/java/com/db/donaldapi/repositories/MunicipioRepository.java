package com.db.donaldapi.repositories;

import com.db.donaldapi.models.dto.MunicipioDto;
import com.db.donaldapi.models.entities.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {
    @Procedure
    List<Municipio> usp_GetMunicipios();

    @Procedure
    void usp_CreateMunicipio(Integer CodigoMunicipio,
                             Integer DepartamentoCodigo,
                             String Descripcion);

    @Procedure
    void usp_UpdateMunicipio(Integer CodigoMunicipio,
                             Integer DepartamentoCodigo,
                             String Descripcion);

    @Procedure
    void usp_DeleteMunicipio(Integer CodigoMunicipio,
                             Integer DepartamentoCodigo);
}
