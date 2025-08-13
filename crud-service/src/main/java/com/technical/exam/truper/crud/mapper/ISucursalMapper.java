package com.technical.exam.truper.crud.mapper;

import com.technical.exam.truper.crud.controller.dto.Sucursal;
import com.technical.exam.truper.crud.repositories.entities.SucursalesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ISucursalMapper {

    @Mapping(target = "nombre", source = "nombre")
    Sucursal toDto(SucursalesEntity sucursalesEntity);
}
