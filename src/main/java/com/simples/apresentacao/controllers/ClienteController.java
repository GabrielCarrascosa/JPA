package com.simples.apresentacao.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simples.apresentacao.entities.ClienteEntidade;
import com.simples.apresentacao.services.ClienteService;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

	private ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		super();
		this.clienteService = clienteService;
	}

	@GetMapping("/findall")
	public List<ClienteEntidade> findAll() {
		return clienteService.findAll();
	}


	@GetMapping("/findallexplicito")
	public List<?> findAllExplicito() {
		return clienteService.findAllExplicito();
	}


	@GetMapping("/findallnativo")
	public List<?> findAllNativo() {
		return clienteService.findAllNativo();
	}

}
