package com.technical.exam.truper.crud.repositories;

import com.technical.exam.truper.crud.repositories.entities.SucursalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ISucursalesRepository extends JpaRepository<SucursalesEntity, Long> {
    Optional<SucursalesEntity> findByIdSucursal(Long idSucursal);

}
