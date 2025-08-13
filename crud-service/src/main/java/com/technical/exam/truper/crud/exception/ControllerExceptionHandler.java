package com.technical.exam.truper.crud.exception;

import com.technical.exam.truper.crud.exception.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex){
        return new ResponseEntity<>(new ErrorResponse(ex.getCode(), ex.getMessage()), ex.getHttpStatus());
    }
}
