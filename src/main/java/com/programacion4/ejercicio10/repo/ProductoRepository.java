package com.programacion4.ejercicio10.repo;

import org.springframework.data.repository.CrudRepository;

import com.programacion4.ejercicio10.models.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
}