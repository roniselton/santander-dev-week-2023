package com.example.santanderdevweek2023.excecoes;

public class BusinessException extends RuntimeException {
    public BusinessException(String s) {
        super( s );
    }
}
