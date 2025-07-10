package br.com.gusmaomatheus.challenge.repository;

import br.com.gusmaomatheus.challenge.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByNome(String nome);
    Optional<Cliente> findByNome(String nome);
}