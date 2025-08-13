package com.technical.exam.truper.crud.mapper;

import com.technical.exam.truper.crud.controller.dto.Orden;
import com.technical.exam.truper.crud.repositories.entities.OrdenesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IOrdenMapper {

    @Mapping(target = "orden_id", source = "ordenId")
    @Mapping(target = "fecha", source = "fecha")
    @Mapping(target = "total", source = "total")
    Orden toDto(OrdenesEntity ordenesEntity);
}
