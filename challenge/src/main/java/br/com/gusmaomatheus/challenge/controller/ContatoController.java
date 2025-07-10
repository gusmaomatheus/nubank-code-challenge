package br.com.gusmaomatheus.challenge.controller;

import br.com.gusmaomatheus.challenge.application.ApiResponse;
import br.com.gusmaomatheus.challenge.model.dto.ContatoRequest;
import br.com.gusmaomatheus.challenge.model.dto.ContatoResponse;
import br.com.gusmaomatheus.challenge.service.ContatoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
    private final ContatoService service;

    public ContatoController(ContatoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ContatoResponse>> inserir (@Valid @RequestBody ContatoRequest contatoRequest,
                                                                 HttpServletRequest request) {
        final ContatoResponse contatoResponse = service.inserir(contatoRequest);
        final ApiResponse<ContatoResponse> body = ApiResponse.success(request, HttpStatus.CREATED, contatoResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }
}