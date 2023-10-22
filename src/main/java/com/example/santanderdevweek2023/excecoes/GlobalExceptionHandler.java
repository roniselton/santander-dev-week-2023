package com.example.santanderdevweek2023.excecoes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handle(IllegalArgumentException illegalArgumentException){
        return new ResponseEntity<>( illegalArgumentException.getMessage() , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handle(NoSuchElementException illegalArgumentException){
        return new ResponseEntity<>( "Item não encontrado", HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handle(Throwable throwable){
        logger.error( "Erro ---> ", throwable );
        return new ResponseEntity<>( "Erro interno", HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
