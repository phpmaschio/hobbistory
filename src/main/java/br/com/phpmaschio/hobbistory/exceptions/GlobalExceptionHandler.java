package br.com.phpmaschio.hobbistory.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.phpmaschio.hobbistory.models.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> notFoundException(NotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(UsuarioJaCadastradoException.class)
    public ResponseEntity<ExceptionResponse> usuarioJaCadastradoException(UsuarioJaCadastradoException ex) {
        return new ResponseEntity<>(new ExceptionResponse(409, ex.getMessage(), LocalDateTime.now()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> badRequestException(Exception ex) {
        return new ResponseEntity<>("Erro ao processar requisição: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
