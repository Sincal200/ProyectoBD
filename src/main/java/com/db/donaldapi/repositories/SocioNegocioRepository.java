package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.SocioNegocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.time.LocalDate;
import java.util.List;

public interface SocioNegocioRepository extends JpaRepository<SocioNegocio, Integer> {
    @Procedure
    List<SocioNegocio> spReadSocios();

    @Procedure
    void spCreateSocio(Integer codigoSocio,
                        String primerNombre,
                        String segundoNombre,
                        String primerApellido,
                        String segundoApellido,
                        LocalDate fechaNacimiento,
                        String cui,
                        String nit,
                        String razonSocial,
                        String genero,
                        Integer codigoTipoSocioNegocio);

    @Procedure
    void spUpdateSocio(Integer codigoSocio,
                       String primerNombre,
                       String segundoNombre,
                       String primerApellido,
                       String segundoApellido,
                       LocalDate fechaNacimiento,
                       String cui,
                       String nit,
                       String razonSocial,
                       String genero,
                       Integer codigoTipoSocioNegocio);

    @Procedure
    void spDeleteSocio(Integer codigoSocio);
}
