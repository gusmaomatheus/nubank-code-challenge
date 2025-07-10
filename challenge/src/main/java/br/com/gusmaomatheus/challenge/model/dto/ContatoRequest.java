package br.com.gusmaomatheus.challenge.model.dto;

import jakarta.validation.constraints.NotBlank;

public record ContatoRequest(
        @NotBlank(message = "É obrigatório informar o nome do cliente.")
        String nomeCliente,
        @NotBlank(message = "É obrigatório informar o telefone.")
        String telefone,
        @NotBlank(message = "É obrigatório informar o email.")
        String email) {}