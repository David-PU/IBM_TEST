package com.metrica.ibmTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metrica.ibmTest.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
