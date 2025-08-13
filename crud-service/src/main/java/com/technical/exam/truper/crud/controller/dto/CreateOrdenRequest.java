package com.technical.exam.truper.crud.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.technical.exam.truper.crud.repositories.entities.ProductosEntity;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrdenRequest {

    @JsonProperty("sucursal_id")
    Long sucursal_id;

    @JsonProperty("productos")
    List<ProductosEntity> productos;

}
