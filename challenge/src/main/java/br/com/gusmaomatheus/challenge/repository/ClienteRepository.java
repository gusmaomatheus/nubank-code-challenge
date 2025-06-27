package br.com.gusmaomatheus.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gusmaomatheus.challenge.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}