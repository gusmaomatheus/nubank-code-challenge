package br.com.gusmaomatheus.challenge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "clientes")
@Entity
@NoArgsConstructor
@Getter
public final class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL)
    private List<Contato> contatos;

    public Cliente(String nome) {
        this.nome = nome;
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        this.contatos.add(contato);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(getId(), cliente.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}