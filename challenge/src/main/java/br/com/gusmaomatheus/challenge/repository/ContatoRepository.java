package br.com.gusmaomatheus.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gusmaomatheus.challenge.model.entity.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}