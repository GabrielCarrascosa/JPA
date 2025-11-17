package com.simples.apresentacao.dtos;

public record ClienteConsultaNativaDTO(
		Long clienteId,
		String clienteNome,
		String clienteEmail,
		Long pedidoId,
		String pedidoDescricao,
		String pedidoData
		) {
}
