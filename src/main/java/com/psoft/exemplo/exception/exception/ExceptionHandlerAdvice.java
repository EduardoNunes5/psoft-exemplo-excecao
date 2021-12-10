package com.psoft.exemplo.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {


    //qualquer exceção lançada de classe que estenda entity not found, será tratada aqui
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomResponseError trataNaoEncontrado(EntityNotFoundException enf){
        return new CustomResponseError(enf.getMessage());
    }

    @ExceptionHandler(EntityExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CustomResponseError trataNaoEncontrado(EntityExistsException enf){
        return new CustomResponseError(enf.getMessage());
    }
}
