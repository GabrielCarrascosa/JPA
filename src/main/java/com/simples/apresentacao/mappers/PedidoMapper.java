package com.simples.apresentacao.mappers;

import org.springframework.stereotype.Component;

import com.simples.apresentacao.dtos.PedidoCreateDTO;
import com.simples.apresentacao.entities.ClienteEntidade;
import com.simples.apresentacao.entities.PedidoEntidade;

@Component
public class PedidoMapper {

	public PedidoEntidade toEntity(PedidoCreateDTO pedidoCreate, ClienteEntidade cliente) {
		return new PedidoEntidade(pedidoCreate.descricao(), pedidoCreate.data(), cliente);
	}
}
