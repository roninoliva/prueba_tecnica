package com.technical.exam.truper.crud.repositories;

import com.technical.exam.truper.crud.repositories.entities.SucursalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISucursalesRepository extends JpaRepository<SucursalesEntity, Long> {
    SucursalesEntity findByIdSucursal(Long idSucursal);

}
