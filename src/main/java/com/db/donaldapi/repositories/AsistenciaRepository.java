package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Asistencia;
import com.db.donaldapi.models.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.time.LocalDateTime;
import java.util.List;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {
    @Procedure
    Asistencia sp_LeerAsistencia(Integer correlativoAsistencia,
                                 Integer codigoEmpleado);

    @Procedure
    void sp_CrearAsistencia(Integer correlativoAsistencia,
                            Integer codigoEmpleado,
                            Integer codigoTipoAsistencia,
                            LocalDateTime fechaIngreso,
                            LocalDateTime fechaEgreso,
                            String origen);

    @Procedure
    void sp_ActualizarAsistencia(Integer correlativoAsistencia,
                                 Integer codigoEmpleado,
                                 LocalDateTime fechaEgreso);

    @Procedure
    void sp_BorrarAsistencia(Integer correlativoAsistencia,
                            Integer codigoEmpleado);
}
