package com.technical.exam.truper.crud.controller;

import com.technical.exam.truper.crud.controller.dto.CreateOrdenRequest;
import com.technical.exam.truper.crud.controller.dto.GetOrdenResponse;
import com.technical.exam.truper.crud.controller.dto.Products;
import com.technical.exam.truper.crud.controller.dto.UpdateProductRequest;
import com.technical.exam.truper.crud.operation.ProductsOperation;
import com.technical.exam.truper.crud.repositories.entities.OrdenesEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsOperation productsOperation;

    @PostMapping("/order/create")
    @PreAuthorize("hasAuthority('SCOPE_crud.write')")
    public ResponseEntity<OrdenesEntity> createOrder(@RequestBody CreateOrdenRequest createOrdenRequest){
        OrdenesEntity createdOrder = productsOperation.createOrden(createOrdenRequest);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping("/order/{id}")
    @PreAuthorize("hasAuthority('SCOPE_crud.read')")
    public ResponseEntity<GetOrdenResponse> getOrderId(@PathVariable Long id){
        return new ResponseEntity<>(productsOperation.getOrden(id), HttpStatus.FOUND);
    }

    @PutMapping("/product/{id}")
    @PreAuthorize("hasAuthority('SCOPE_crud.update')")
    public ResponseEntity<Products> updateProduct(@PathVariable("id") Long id, @RequestBody UpdateProductRequest updateProductRequest){
        return new ResponseEntity<>(productsOperation.updateProduct(id, updateProductRequest), HttpStatus.OK);
    }

}
