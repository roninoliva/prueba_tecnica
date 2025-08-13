package com.technical.exam.truper.crud.repositories;

import com.technical.exam.truper.crud.repositories.entities.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductosRepository extends JpaRepository<ProductosEntity, Long> {}
