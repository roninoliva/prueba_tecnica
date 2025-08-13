package com.technical.exam.truper.crud.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetOrdenResponse {

    @JsonProperty("sucursales")
    Sucursal sucursal;

    @JsonProperty("orden")
    Orden orden;

    @JsonProperty("productos")
    List<Products> productos;

}
