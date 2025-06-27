package br.com.gusmaomatheus.challenge.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteRequest(
        @NotNull(message = "É obrigatório informar o nome.")
        @NotBlank(message = "É obrigatório informar o nome.")
        String nome) {
}