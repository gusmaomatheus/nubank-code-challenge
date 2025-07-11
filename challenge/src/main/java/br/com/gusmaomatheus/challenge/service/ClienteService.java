package br.com.gusmaomatheus.challenge.service;

import br.com.gusmaomatheus.challenge.application.exception.ResourceAlreadyExistsException;
import br.com.gusmaomatheus.challenge.model.dto.ClienteResponse;
import br.com.gusmaomatheus.challenge.model.dto.ContatoResponse;
import br.com.gusmaomatheus.challenge.model.entity.Cliente;
import br.com.gusmaomatheus.challenge.model.mapper.cliente.ClienteResponseMapper;
import br.com.gusmaomatheus.challenge.model.mapper.contato.ContatoResponseMapper;
import br.com.gusmaomatheus.challenge.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public final class ClienteService {
    private final ClienteRepository repository;
    private final ClienteResponseMapper clienteMapper;
    private final ContatoResponseMapper contatoMapper;


    public ClienteService(ClienteRepository repository,ClienteResponseMapper clienteMapper, ContatoResponseMapper contatoMapper) {
        this.repository = repository;
        this.clienteMapper = clienteMapper;
        this.contatoMapper = contatoMapper;
    }

    public ClienteResponse inserir(Cliente cliente) {
        Objects.requireNonNull(cliente, "Cliente must not be null.");

        if (repository.existsByNome(cliente.getNome())) {
            final String message = String.format("Cliente '%s' já existe.", cliente.getNome());

            throw new ResourceAlreadyExistsException(message);
        }

        repository.save(cliente);

        return clienteMapper.toDto(cliente);
    }

    public List<ClienteResponse> listar() {
        return repository.findAll()
                .stream()
                // Stream dentro de stream == matei um panda
                .map(cliente -> {
                    final List<ContatoResponse> contatos =  cliente.getContatos()
                            .stream()
                            .map(contatoMapper::toDto)
                            .toList();

                    return clienteMapper.toDto(cliente);
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
                .map(contatoMapper::toDto)
                .toList();
    }
}