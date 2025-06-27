package br.com.gusmaomatheus.challenge.model.entity;

import java.util.Objects;
import java.util.regex.Pattern;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contatos")
@NoArgsConstructor
@Getter
public final class Contato {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String telefone;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Contato(String email, String telefone, Cliente cliente) {
        setEmail(email);
        setTelefone(telefone);
        setCliente(cliente);
    }

    private boolean validarEmail(String email) {
        if (Objects.isNull(email))
            return false;
        if (email.isEmpty())
            return false;

        final String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(email).matches();
    }

    public void setEmail(String email) {
        if (!validarEmail(email)) {
            throw new IllegalArgumentException("Email inválido: " + email);
        }

        this.email = email;
    }

    public void setTelefone(String telefone) {
        Objects.requireNonNull(telefone);

        this.telefone = telefone;
    }

    public void setCliente(Cliente cliente) {
        Objects.requireNonNull(cliente);

        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Contato contato = (Contato) o;
        return Objects.equals(getId(), contato.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}