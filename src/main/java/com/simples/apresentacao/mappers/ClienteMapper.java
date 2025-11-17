package com.simples.apresentacao.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.simples.apresentacao.dtos.ClienteComPedidosDTO;
import com.simples.apresentacao.dtos.ClienteCreateDTO;
import com.simples.apresentacao.dtos.ClienteDTO;
import com.simples.apresentacao.dtos.PedidoDTO;
import com.simples.apresentacao.entities.ClienteEntidade;
import com.simples.apresentacao.entities.PedidoEntidade;

@Component
public class ClienteMapper {

	public ClienteEntidade toEntity(ClienteCreateDTO clienteCreate) {
		return new ClienteEntidade(null, clienteCreate.nome(), clienteCreate.email());
	}

	// Mapper recebendo a entidade Cliente
	public ClienteDTO toClienteDTO(ClienteEntidade cliente) {
		return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getEmail());
	}

	// Mapper recebendo a entidade Cliente, também irá mapear os pedidos
	public ClienteComPedidosDTO toClienteComPedidosDTO(ClienteEntidade cliente) {
		List<PedidoEntidade> pedidos = cliente.getPedidos();
		List<PedidoDTO> pedidosDTO = pedidos.stream()
				.map(pedido -> new PedidoDTO(pedido.getId(), pedido.getDescricao(), pedido.getData())).toList();

		return new ClienteComPedidosDTO(cliente.getId(), cliente.getNome(), cliente.getEmail(), pedidosDTO);
	}
	


}
