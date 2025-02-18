package com.example.teste_maxiprod.infra.exceptions;

import org.springframework.http.HttpStatus;

public record ErrorMessage(HttpStatus status, String message) {
}
