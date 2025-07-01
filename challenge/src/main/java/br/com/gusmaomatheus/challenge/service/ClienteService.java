package br.com.gusmaomatheus.challenge.service;

import br.com.gusmaomatheus.challenge.application.exception.ResourceAlreadyExistsException;
import br.com.gusmaomatheus.challenge.model.dto.ClienteResponse;
import br.com.gusmaomatheus.challenge.model.entity.Cliente;
import br.com.gusmaomatheus.challenge.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;

@Service
public final class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public ClienteResponse inserir(Cliente cliente) {
        Objects.requireNonNull(cliente, "Cliente must not be null.");

        if (repository.existsByNome(cliente.getNome())) {
            final String message = String.format("Cliente '%s' já existe.", cliente.getNome());

            throw new ResourceAlreadyExistsException(message);
        }

        repository.save(cliente);

        return new ClienteResponse(cliente.getId(), cliente.getNome(), Collections.emptyList());
    }
}