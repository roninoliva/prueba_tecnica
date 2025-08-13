package com.technical.exam.truper.crud.operation;

import com.technical.exam.truper.crud.controller.dto.CreateOrdenRequest;
import com.technical.exam.truper.crud.repositories.IOrdenesRepository;
import com.technical.exam.truper.crud.repositories.IProductosRepository;
import com.technical.exam.truper.crud.repositories.ISucursalesRepository;
import com.technical.exam.truper.crud.repositories.entities.OrdenesEntity;
import com.technical.exam.truper.crud.repositories.entities.ProductosEntity;
import com.technical.exam.truper.crud.repositories.entities.SucursalesEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductsOperation {

    private final IOrdenesRepository ordenesRepository;
    private final ISucursalesRepository sucursalesRepository;
    private final IProductosRepository productosRepository;

    @Transactional(rollbackOn = RuntimeException.class)
    public OrdenesEntity createOrden(CreateOrdenRequest createOrdenRequest){

        // Consulta de la sucursal
        SucursalesEntity sucursalesEntity = sucursalesRepository.findByIdSucursal(createOrdenRequest.getSucursal_id());

        List<ProductosEntity> productos = createOrdenRequest.getProductos();
        Double precioTotal = 0.0;
        for(ProductosEntity p: productos){
            precioTotal += p.getPrecio();
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
                    .idProducto(i.getIdProducto())
                    .descripcion(i.getDescripcion())
                    .ordenesEntity(createdOrder)
                    .build();

            productosRepository.save(productosEntity);
        });

        return createdOrder;
    }


}
