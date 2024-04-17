DROP DATABASE IF EXISTS ibm_bbdd;

CREATE DATABASE IF NOT EXISTS ibm_bbdd;

USE ibm_bbdd;

CREATE TABLE IF NOT EXISTS clientes (
  id_cliente INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL
);

INSERT INTO clientes (id_cliente, nombre)
VALUES
  (1, 'Tienda 1'),
  (2, 'Tienda 2'),
  (3, 'Tienda 3'),
  (4, 'Tienda 4'),
  (5, 'Tienda 5');

CREATE TABLE IF NOT EXISTS proveedores (
  id_proveedor INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  fecha_alta DATE NOT NULL,
  id_cliente INT NOT NULL,
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

INSERT INTO proveedores (id_proveedor, nombre, fecha_alta, id_cliente)
VALUES
  (1, 'Coca-Cola', STR_TO_DATE('2024-04-15', '%Y-%m-%d'), 1),
  (2, 'Pepsi', STR_TO_DATE('2024-04-15', '%Y-%m-%d'), 1),
  (3, 'Redbull', STR_TO_DATE('2024-04-15', '%Y-%m-%d'), 2),
  (4, 'Fanta', STR_TO_DATE('2024-04-15', '%Y-%m-%d'), 3),
  (5, 'Casera', STR_TO_DATE('2024-04-15', '%Y-%m-%d'), 4),
  (6, 'Trina', STR_TO_DATE('2024-04-15', '%Y-%m-%d'), 3);