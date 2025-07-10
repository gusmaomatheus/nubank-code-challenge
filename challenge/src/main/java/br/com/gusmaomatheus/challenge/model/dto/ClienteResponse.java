package br.com.gusmaomatheus.challenge.model.dto;

import java.util.List;

public record ClienteResponse(Long id, String nome, List<ContatoResponse> contatos) {}