package com.simples.apresentacao.dtos;

import java.util.List;

public record ClienteNativoDTO(
		Long id,
		String nome,
		String email,
		List<PedidoNativoDTO> pedidos
) {

}
