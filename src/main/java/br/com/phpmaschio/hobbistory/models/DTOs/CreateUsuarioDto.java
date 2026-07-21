package br.com.phpmaschio.hobbistory.models.DTOs;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUsuarioDto(
    @Length(max = 50, min = 3, message = "login deve conter entre 3 à 50 caracteres")
    @NotBlank(message = "O campo login não pode ser em branco")
    @NotNull(message = "O campo login é obrigatório")
    String login
) {

}
