package br.com.phpmaschio.hobbistory.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record ExceptionResponse(
    int status,
    String mensagem,
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    LocalDateTime dataHora
) {

}
