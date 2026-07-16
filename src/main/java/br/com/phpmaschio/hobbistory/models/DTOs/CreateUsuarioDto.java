package br.com.phpmaschio.hobbistory.models.DTOs;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUsuarioDto(
    @Max(value = 50, message = "login deve conter no máximo 50 caracteres")
    @Min(value = 3, message = "login deve conter no minimo 3 caracteres")
    @NotBlank(message = "O campo login não pode ser em branco")
    @NotNull(message = "O campo login é obrigatório")
    String login
) {

}
