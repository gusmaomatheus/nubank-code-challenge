package br.com.gusmaomatheus.challenge.service;

import br.com.gusmaomatheus.challenge.model.dto.ContatoRequest;
import br.com.gusmaomatheus.challenge.model.dto.ContatoResponse;
import br.com.gusmaomatheus.challenge.model.entity.Cliente;
import br.com.gusmaomatheus.challenge.model.entity.Contato;
import br.com.gusmaomatheus.challenge.model.mapper.contato.ContatoRequestMapper;
import br.com.gusmaomatheus.challenge.model.mapper.contato.ContatoResponseMapper;
import br.com.gusmaomatheus.challenge.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public final class ContatoService {
    private final ClienteRepository repository;
    private final ContatoRequestMapper requestEntityMapper;
    private final ContatoResponseMapper responseEntityMapper;

    public ContatoService(ClienteRepository repository,ContatoRequestMapper requestEntityMapper, ContatoResponseMapper responseEntityMapper) {
        this.repository = repository;
        this.requestEntityMapper = requestEntityMapper;
        this.responseEntityMapper = responseEntityMapper;
    }

    public ContatoResponse inserir(ContatoRequest contatoRequest) {
        final String nomeCliente = contatoRequest.nomeCliente();
        final Cliente cliente = repository.findByNome(nomeCliente).orElseThrow(() -> {
            final String errorMesage = String.format("O cliente '%s' não existe!", nomeCliente);

            return new NoSuchElementException(errorMesage);
        });

        final Contato contato = requestEntityMapper.toEntity(contatoRequest);

        cliente.adicionarContato(contato);

        repository.save(cliente);

        return responseEntityMapper.toDto(contato);
    }
}