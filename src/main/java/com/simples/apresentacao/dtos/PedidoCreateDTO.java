package com.simples.apresentacao.dtos;


public record PedidoCreateDTO(
		String descricao,
		String data,
		Long clienteId
) {
}
