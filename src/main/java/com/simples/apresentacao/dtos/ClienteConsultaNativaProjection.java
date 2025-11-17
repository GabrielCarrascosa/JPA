package com.simples.apresentacao.dtos;

public interface ClienteConsultaNativaProjection {
	Long getClienteId();
	String getClienteNome();
	String getClienteEmail();
	Long getPedidoId();
	String getPedidoDescricao();
	String getPedidoData();
}
