package com.db.donaldapi.controllers;

import com.db.donaldapi.models.entities.Cliente;
import com.db.donaldapi.models.entities.Marca;
import com.db.donaldapi.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @GetMapping("/{codigoCliente}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public Cliente find(@PathVariable Integer codigoCliente){
        return clienteRepository.sp_LeerCliente(codigoCliente);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody Cliente cliente){
        clienteRepository.sp_CrearCliente(
                cliente.getCodigoCliente(),
                cliente.getCodigoSocio()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Transactional
    public void update(@RequestBody Cliente cliente){
        clienteRepository.sp_ActualizarCliente(
                cliente.getCodigoCliente(),
                cliente.getCodigoSocio()
        );
    }

    @DeleteMapping("/{codigoCliente}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteById(@PathVariable Integer codigoCliente){
        clienteRepository.sp_EliminarCliente(codigoCliente);
    }
}
