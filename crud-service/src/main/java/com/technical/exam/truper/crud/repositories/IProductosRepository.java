package com.technical.exam.truper.crud.repositories;

import com.technical.exam.truper.crud.repositories.entities.OrdenesEntity;
import com.technical.exam.truper.crud.repositories.entities.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IProductosRepository extends JpaRepository<ProductosEntity, Long> {

    List<ProductosEntity> findByOrdenesEntity(OrdenesEntity ordenesEntity);

    Optional<ProductosEntity> findByIdProducto(Long idProducto);
    
}
