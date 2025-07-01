package br.com.gusmaomatheus.challenge.controller;

import br.com.gusmaomatheus.challenge.model.dto.ClienteRequest;
import br.com.gusmaomatheus.challenge.model.entity.Cliente;
import br.com.gusmaomatheus.challenge.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity inserir(@Valid @RequestBody ClienteRequest clienteRequest) {
        service.inserir(new Cliente(clienteRequest.nome()));

        return ResponseEntity.ok().build();
    }
}