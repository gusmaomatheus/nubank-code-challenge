package br.com.gusmaomatheus.challenge.model.mapper.cliente;

import br.com.gusmaomatheus.challenge.model.dto.ClienteResponse;
import br.com.gusmaomatheus.challenge.model.entity.Cliente;
import br.com.gusmaomatheus.challenge.model.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteResponseMapper extends EntityMapper<Cliente, ClienteResponse> {

    @Override
    @Mapping(target = "contatos", ignore = true)
    Cliente toEntity(ClienteResponse dto);
}