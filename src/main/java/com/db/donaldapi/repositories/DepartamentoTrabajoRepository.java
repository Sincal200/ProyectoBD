package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.DepartamentoTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface DepartamentoTrabajoRepository extends JpaRepository<DepartamentoTrabajo, Integer> {
    @Procedure
    List<DepartamentoTrabajo> sp_leer_departamentos_trabajo();

    @Procedure
    void sp_insertar_departamento_trabajo(Integer codigoDepartamentoTrabajo, String descripcion);

    @Procedure
    void sp_actualizar_departamento_trabajo(Integer codigoDepartamentoTrabajo, String descripcion);

    @Procedure
    void sp_eliminar_departamento_trabajo(Integer codigoDepartamentoTrabajo);
}
