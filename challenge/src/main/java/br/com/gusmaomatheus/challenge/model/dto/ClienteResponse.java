package br.com.gusmaomatheus.challenge.model.dto;

import br.com.gusmaomatheus.challenge.model.entity.Contato;

import java.util.List;

public record ClienteResponse(Long id, String nome, List<Contato> contatos) {}