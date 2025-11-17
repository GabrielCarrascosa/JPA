package com.simples.apresentacao.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simples.apresentacao.dtos.PedidoCreateDTO;
import com.simples.apresentacao.entities.PedidoEntidade;
import com.simples.apresentacao.services.PedidoService;

@RestController
@RequestMapping("api/pedidos")
public class PedidoController {

	private PedidoService pedidoService;

	public PedidoController(PedidoService pedidoService) {
		super();
		this.pedidoService = pedidoService;
	}

	@PostMapping
	public PedidoEntidade save(@RequestBody PedidoCreateDTO pedidoCreate) {
		return pedidoService.save(pedidoCreate);
	}

}
