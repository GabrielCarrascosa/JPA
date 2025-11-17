package com.simples.apresentacao.dtos;

import java.util.List;

public record ClienteComPedidosDTO(
		Long id,
		String nome,
		String email,
		List<PedidoDTO> pedidos
		) {
}
