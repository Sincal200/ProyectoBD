package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.models.entities.Taller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface TallerRepository extends JpaRepository<Taller, Integer> {
    //    CodigoTaller (int, PK)
    //    RazonSocial (varchar(60))
    //    NombreComercial (varchar(60))
    //    NIT (varchar(20))
    @Procedure
    List<Taller> spReadTalleres();

    @Procedure
    void spCreateTaller(Integer CodigoTaller,
                        String RazonSocial,
                        String NombreComercial,
                        String NIT);

    @Procedure
    void spUpdateTaller(Integer CodigoTaller,
                        String RazonSocial,
                        String NombreComercial,
                        String NIT);

    @Procedure
    void spDeleteTaller(Integer CodigoTaller);
}
