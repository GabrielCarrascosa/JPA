package com.simples.apresentacao.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class PedidoEntidade {

	@Id
	@Column(name = "pedido_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String data;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cliente_id", nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private ClienteEntidade cliente;

	public PedidoEntidade() {

	}

	public PedidoEntidade(String descricao, String data, ClienteEntidade cliente) {
		super();
		this.descricao = descricao;
		this.data = data;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ClienteEntidade getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntidade cliente) {
		this.cliente = cliente;
	}

}
