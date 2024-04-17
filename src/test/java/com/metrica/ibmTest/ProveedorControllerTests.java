package com.metrica.ibmTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.metrica.ibmTest.entity.Cliente;
import com.metrica.ibmTest.entity.Proveedor;
import com.metrica.ibmTest.repository.ClienteRepository;
import com.metrica.ibmTest.repository.ProveedorRepository;



@SpringBootTest
public class ProveedorControllerTests {

    @Autowired
    private ProveedorRepository proveedorRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void proveedoresPorCliente() {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setNombre("Tienda 1");
        
        Cliente cliente2 = new Cliente();
        cliente2.setIdCliente(2L);
        cliente2.setNombre("Tienda 2");
        
        Cliente cliente3 = new Cliente();
        cliente3.setIdCliente(3L);
        cliente3.setNombre("Tienda 3");
        
        Cliente cliente4 = new Cliente();
        cliente4.setIdCliente(4L);
        cliente4.setNombre("Tienda 4");
        
        Cliente cliente5 = new Cliente();
        cliente5.setIdCliente(5L);
        cliente5.setNombre("Tienda 5");
        
        clienteRepository.saveAll(Arrays.asList(cliente, cliente2, cliente3, cliente4, cliente5));

        Proveedor proveedor1 = new Proveedor();
        proveedor1.setIdProveedor(1L);
        proveedor1.setNombre("Coca-Cola");
        proveedor1.setFechaAlta(LocalDate.now());
        proveedor1.setIdCliente(cliente.getIdCliente());

        Proveedor proveedor2 = new Proveedor();
        proveedor2.setIdProveedor(2L);
        proveedor2.setNombre("Pepsi");
        proveedor2.setFechaAlta(LocalDate.now());
        proveedor2.setIdCliente(cliente.getIdCliente());
        
        Proveedor proveedor3 = new Proveedor();
        proveedor3.setIdProveedor(3L);
        proveedor3.setNombre("Redbull");
        proveedor3.setFechaAlta(LocalDate.now());
        proveedor3.setIdCliente(cliente2.getIdCliente());
        
        Proveedor proveedor4 = new Proveedor();
        proveedor4.setIdProveedor(4L);
        proveedor4.setNombre("Fanta");
        proveedor4.setFechaAlta(LocalDate.now());
        proveedor4.setIdCliente(cliente3.getIdCliente());
        
        Proveedor proveedor5 = new Proveedor();
        proveedor5.setIdProveedor(5L);
        proveedor5.setNombre("Casera");
        proveedor5.setFechaAlta(LocalDate.now());
        proveedor5.setIdCliente(cliente4.getIdCliente());
        
        Proveedor proveedor6 = new Proveedor();
        proveedor6.setIdProveedor(6L);
        proveedor6.setNombre("Trina");
        proveedor6.setFechaAlta(LocalDate.now());
        proveedor6.setIdCliente(cliente3.getIdCliente());

        proveedorRepository.saveAll(Arrays.asList(proveedor1, proveedor2, proveedor3, proveedor4, proveedor5, proveedor6));

        List<Proveedor> proveedores = proveedorRepository.findByIdCliente(cliente.getIdCliente());
        // Comprobamos que todo se inserta bien
        assertThat(proveedores.size() == 6);
        assertEquals(proveedores.get(0).getNombre(), "Coca-Cola");
        assertEquals(proveedores.get(1).getNombre(), "Pepsi");
        
        List<Proveedor> proveedoresVacia = proveedorRepository.findByIdCliente(cliente5.getIdCliente());
        // Comprobamos que un cliente sin proveedores devuelve un array vacío
        assertThat(proveedoresVacia.size() == 0);
    }

}
