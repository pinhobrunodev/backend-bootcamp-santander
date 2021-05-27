package com.project.bootcamp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// Intercepta quando ocorrer alguma exception e retorna pro front o status code
@ControllerAdvice
//  Tratar exceptions de Respostas
public class ExceptionHandlers extends ResponseEntityExceptionHandler {

    // Controla o tipo de exception que acontecer no Service

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ExceptionResponse> handlerSecurity(BusinessException e){
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ExceptionResponse(e.getMessage())); // ALGUM ERRO DE NEGOCIO
    }


    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ExceptionResponse> handlerhandlerSecurity(NotFoundException e){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(e.getMessage())); // ALGUM ERRO DE NEGOCIO
    }
 
    

}
