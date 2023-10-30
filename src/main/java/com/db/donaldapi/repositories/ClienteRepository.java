package com.db.donaldapi.repositories;

import com.db.donaldapi.models.entities.Cliente;
import com.db.donaldapi.models.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Procedure
    Cliente sp_LeerCliente(Integer codigoCliente);

    @Procedure
    void sp_CrearCliente(Integer codigoCliente, Integer codigoSocio);

    @Procedure
    void sp_ActualizarCliente(Integer codigoCliente, Integer codigoSocio);

    @Procedure
    void sp_EliminarCliente(Integer codigoCliente);
}
