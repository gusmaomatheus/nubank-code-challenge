package br.com.gusmaomatheus.challenge.service;

import br.com.gusmaomatheus.challenge.model.dto.ContatoRequest;
import br.com.gusmaomatheus.challenge.model.dto.ContatoResponse;
import br.com.gusmaomatheus.challenge.model.entity.Cliente;
import br.com.gusmaomatheus.challenge.model.entity.Contato;
import br.com.gusmaomatheus.challenge.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public final class ContatoService {
    private final ClienteRepository repository;

    public ContatoService(ClienteRepository repository) {
        this.repository = repository;
    }

    public ContatoResponse inserir(ContatoRequest contatoRequest) {
        final String nomeCliente = contatoRequest.nomeCliente();
        final Cliente cliente = repository.findByNome(nomeCliente).orElseThrow(() -> {
            final String errorMesage = String.format("O cliente '%s' não existe!", nomeCliente);

            return new NoSuchElementException(errorMesage);
        });

        final Contato contato = new Contato(contatoRequest.email(), contatoRequest.telefone(), cliente);

        cliente.adicionarContato(contato);

        repository.save(cliente);

        return new ContatoResponse(contato.getEmail(), contato.getTelefone());
    }
}