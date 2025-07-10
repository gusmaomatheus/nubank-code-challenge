package br.com.gusmaomatheus.challenge.service;

import br.com.gusmaomatheus.challenge.application.exception.ResourceAlreadyExistsException;
import br.com.gusmaomatheus.challenge.model.dto.ClienteResponse;
import br.com.gusmaomatheus.challenge.model.dto.ContatoResponse;
import br.com.gusmaomatheus.challenge.model.entity.Cliente;
import br.com.gusmaomatheus.challenge.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<ClienteResponse> listar() {
        return repository.findAll()
                .stream()
                // Stream dentro de stream == matei um panda
                .map(cliente -> {
                    final List<ContatoResponse> contatos =  cliente.getContatos()
                            .stream()
                            .map(contato -> new ContatoResponse(contato.getEmail(), contato.getTelefone()))
                            .toList();

                    return new ClienteResponse(cliente.getId(), cliente.getNome(), contatos);
                })
                .collect(Collectors.toList());
    }

    public List<ContatoResponse> listarContatos(Long id) {
        final Cliente cliente = repository.findById(id).orElseThrow(() -> {
            final String errorMesage = String.format("O cliente de id '%d' não existe!", id);

            return new NoSuchElementException(errorMesage);
        });

        return cliente.getContatos()
                .stream()
                .map(contato -> new ContatoResponse(contato.getEmail(), contato.getTelefone()))
                .toList();
    }
}