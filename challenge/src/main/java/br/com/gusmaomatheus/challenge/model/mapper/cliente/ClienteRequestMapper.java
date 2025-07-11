package br.com.gusmaomatheus.challenge.model.mapper.cliente;

import br.com.gusmaomatheus.challenge.model.dto.ClienteRequest;
import br.com.gusmaomatheus.challenge.model.entity.Cliente;
import br.com.gusmaomatheus.challenge.model.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteRequestMapper extends EntityMapper<Cliente, ClienteRequest> {
    @Override
    @Mapping(target = "contatos", ignore = true)
    Cliente toEntity(ClienteRequest dto);
}