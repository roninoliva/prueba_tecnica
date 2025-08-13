package com.technical.exam.truper.crud.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class BusinessException extends RuntimeException {

    private String code;
    private String message;
    private HttpStatus httpStatus;

}
