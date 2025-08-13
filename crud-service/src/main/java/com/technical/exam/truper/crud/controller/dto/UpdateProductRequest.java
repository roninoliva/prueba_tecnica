package com.technical.exam.truper.crud.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UpdateProductRequest {

    @JsonProperty("precio")
    private Double precio;

}
