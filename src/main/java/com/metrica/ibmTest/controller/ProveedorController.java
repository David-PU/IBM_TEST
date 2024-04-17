package com.metrica.ibmTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metrica.ibmTest.entity.Proveedor;
import com.metrica.ibmTest.repository.ProveedorRepository;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping("/porIdCliente/{idCliente}")
    public List<Proveedor> encontrarPorIdCliente(@PathVariable Long idCliente) {
        return proveedorRepository.findByIdCliente(idCliente);
    }
}