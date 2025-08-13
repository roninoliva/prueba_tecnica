package com.technical.exam.truper.crud.controller;

import com.technical.exam.truper.crud.controller.dto.CreateOrdenRequest;
import com.technical.exam.truper.crud.operation.ProductsOperation;
import com.technical.exam.truper.crud.repositories.entities.OrdenesEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsOperation productsOperation;

    @PostMapping("/order/create")
    @PreAuthorize("hasAuthority('SCOPE_crud.update')")
    public ResponseEntity<OrdenesEntity> createOrder(@RequestBody CreateOrdenRequest createOrdenRequest){
        OrdenesEntity createdOrder = productsOperation.createOrden(createOrdenRequest);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);

    }

}
