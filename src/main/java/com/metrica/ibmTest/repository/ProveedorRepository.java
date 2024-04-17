package com.metrica.ibmTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metrica.ibmTest.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    List<Proveedor> findByIdCliente(Long idCliente);
}
