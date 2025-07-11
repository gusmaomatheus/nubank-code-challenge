package br.com.gusmaomatheus.challenge.model.mapper.contato;

import br.com.gusmaomatheus.challenge.model.dto.ContatoResponse;
import br.com.gusmaomatheus.challenge.model.entity.Contato;
import br.com.gusmaomatheus.challenge.model.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContatoResponseMapper extends EntityMapper<Contato, ContatoResponse> {
    @Override
    @Mapping(target = "cliente", ignore = true)
    Contato toEntity(ContatoResponse dto);
}