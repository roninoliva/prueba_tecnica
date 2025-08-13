package com.technical.exam.truper.crud.operation;

import com.technical.exam.truper.crud.controller.dto.CreateOrdenRequest;
import com.technical.exam.truper.crud.controller.dto.GetOrdenResponse;
import com.technical.exam.truper.crud.controller.dto.Products;
import com.technical.exam.truper.crud.controller.dto.UpdateProductRequest;
import com.technical.exam.truper.crud.exception.BusinessException;
import com.technical.exam.truper.crud.mapper.IOrdenMapper;
import com.technical.exam.truper.crud.mapper.IProductsMapper;
import com.technical.exam.truper.crud.mapper.ISucursalMapper;
import com.technical.exam.truper.crud.repositories.IOrdenesRepository;
import com.technical.exam.truper.crud.repositories.IProductosRepository;
import com.technical.exam.truper.crud.repositories.ISucursalesRepository;
import com.technical.exam.truper.crud.repositories.entities.OrdenesEntity;
import com.technical.exam.truper.crud.repositories.entities.ProductosEntity;
import com.technical.exam.truper.crud.repositories.entities.SucursalesEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductsOperation {

    private final IOrdenesRepository ordenesRepository;
    private final ISucursalesRepository sucursalesRepository;
    private final IProductosRepository productosRepository;

    private final IProductsMapper productsMapper;
    private final IOrdenMapper ordenMapper;
    private final ISucursalMapper sucursalMapper;

    @Transactional(rollbackFor = RuntimeException.class)
    public Products updateProduct(Long id, UpdateProductRequest updateProductRequest){

        // Consulta del producto
        ProductosEntity productos = productosRepository.findByIdProducto(id)
                .orElseThrow(() -> new BusinessException("003-CRUD", "El producto especificado no existe", HttpStatus.NOT_FOUND));

        // Actualizacion del producto
        productos.setPrecio(updateProductRequest.getPrecio());
        productosRepository.save(productos);
        return productsMapper.toDto(productos);
    }

    @Transactional(readOnly = true)
    public GetOrdenResponse getOrden(Long ordenId){

        // Consulta de la orden
        OrdenesEntity orden = ordenesRepository.findById(ordenId)
                .orElseThrow(() -> new BusinessException("002-CRUD", "La orden proporcionada no existe", HttpStatus.NOT_FOUND));

        // Consulta de productos de la orden
        List<ProductosEntity> productos = productosRepository.findByOrdenesEntity(orden);

        return GetOrdenResponse.builder()
                .orden(ordenMapper.toDto(orden))
                .productos(productsMapper.toDtoList(productos))
                .sucursal(sucursalMapper.toDto(orden.getSucursal()))
                .build();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public OrdenesEntity createOrden(CreateOrdenRequest createOrdenRequest){

        // Consulta de la sucursal
        SucursalesEntity sucursalesEntity = sucursalesRepository.findByIdSucursal(createOrdenRequest.getSucursal_id())
                .orElseThrow(() -> new BusinessException("001-CRUD", "La sucursal no existe", HttpStatus.NOT_FOUND));

        List<Products> productos = createOrdenRequest.getProductos();
        Double precioTotal = 0.0;
        for(Products p: productos){
            precioTotal += p.precio();
        }

        // Creacion de la orden
        OrdenesEntity ordenesEntity = OrdenesEntity.builder()
                .sucursal(sucursalesEntity)
                .fecha(LocalDate.now())
                .total(precioTotal)
                .build();
        OrdenesEntity createdOrder = ordenesRepository.save(ordenesEntity);

        // Creacion de los productos
        productos.forEach(i -> {
            ProductosEntity productosEntity = ProductosEntity.builder()
                    .idProducto(i.id_producto())
                    .descripcion(i.descripcion())
                    .precio(i.precio())
                    .ordenesEntity(createdOrder)
                    .build();

            productosRepository.save(productosEntity);
        });

        return createdOrder;
    }


}
