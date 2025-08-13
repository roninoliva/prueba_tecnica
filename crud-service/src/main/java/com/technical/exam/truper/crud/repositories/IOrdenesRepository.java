package com.technical.exam.truper.crud.repositories;

import com.technical.exam.truper.crud.repositories.entities.OrdenesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdenesRepository extends JpaRepository<OrdenesEntity, Long> {
}
