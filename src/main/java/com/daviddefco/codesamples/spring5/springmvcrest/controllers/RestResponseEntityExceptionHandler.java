package com.daviddefco.codesamples.spring5.springmvcrest.controllers;

import com.daviddefco.codesamples.spring5.springmvcrest.services.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleNotFOundException(Exception exception, WebRequest request) {
        return new ResponseEntity<>("Resource not Found", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
