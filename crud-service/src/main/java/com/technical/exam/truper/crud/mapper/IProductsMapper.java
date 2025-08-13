package com.technical.exam.truper.crud.mapper;

import com.technical.exam.truper.crud.controller.dto.Products;
import com.technical.exam.truper.crud.repositories.entities.ProductosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IProductsMapper {

    @Mapping(target = "id_producto", source = "productosEntity.idProducto")
    @Mapping(target = "descripcion", source = "productosEntity.descripcion")
    @Mapping(target = "precio", source = "productosEntity.precio")
    Products toDto(ProductosEntity productosEntity);

    List<Products> toDtoList(List<ProductosEntity> productosEntities);

}
