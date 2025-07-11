package br.com.gusmaomatheus.challenge.model.mapper.contato;

import br.com.gusmaomatheus.challenge.model.dto.ContatoRequest;
import br.com.gusmaomatheus.challenge.model.entity.Contato;
import br.com.gusmaomatheus.challenge.model.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContatoRequestMapper extends EntityMapper<Contato, ContatoRequest> {
    @Override
    @Mapping(target = "cliente", ignore = true)
    Contato toEntity(ContatoRequest dto);

    @Override
    @Mapping(target = "nomeCliente", ignore = true)
    ContatoRequest toDto(Contato entity);
}