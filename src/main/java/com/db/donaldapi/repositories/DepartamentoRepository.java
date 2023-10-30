package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
    @Procedure
    List<Departamento> sp_leer_departamentos();

    @Procedure
    void sp_insertar_departamento(Integer codigoDepartamento, String descripcion);

    @Procedure
    void sp_actualizar_departamento(Integer codigoDepartamento, String descripcion);

    @Procedure
    void sp_eliminar_departamento(Integer codigoDepartamento);
}
