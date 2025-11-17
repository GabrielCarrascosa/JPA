package com.simples.apresentacao.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simples.apresentacao.dtos.ClienteComPedidosDTO;
import com.simples.apresentacao.dtos.ClienteConsultaNativaDTO;
import com.simples.apresentacao.dtos.ClienteConsultaNativaProjection;
import com.simples.apresentacao.dtos.ClienteCreateDTO;
import com.simples.apresentacao.dtos.ClienteDTO;
import com.simples.apresentacao.dtos.ClienteNativoDTO;
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

	@GetMapping("/findAll")
	public List<ClienteDTO> findAll() {
		return clienteService.findAll();
	}

	@GetMapping("/findAllComPedidos")
	public List<ClienteComPedidosDTO> findAllComPedidos() {
		return clienteService.findAllComPedidos();
	}

	
	
	
	
	

	@GetMapping("/findAllExplicito")
	public List<ClienteDTO> findAllExplicito() {
		return clienteService.findAllExplicito();
	}
	
	@GetMapping("/findAllExplicitoComPedidos")
	public List<ClienteComPedidosDTO> findAllExplicitoComPedidos() {
		return clienteService.findAllExplicitoComPedidos();
	}
	
	
	
	
	
	
	
	@GetMapping("/findAllNativoComDTO")
	public List<ClienteConsultaNativaDTO> findAllNativoComDTO() {
		return clienteService.findAllNativoComDTO();
	}

	@GetMapping("/findAllNativoComProjection")
	public List<ClienteConsultaNativaProjection> findAllNativoComProjection() {
		return clienteService.findAllNativoComProjection();
	}

	@GetMapping("/findAllClientesNativo")
	public List<ClienteDTO> findAllClientesNativo() {
		return clienteService.findAllClientesNativo();
	}

	
	
	
	

	@GetMapping("/findAllNativo")
	public List<ClienteNativoDTO> findAllNativo() {
		return clienteService.findAllNativo();
	}

	@GetMapping("/findAllNativoComDTOReestruturado")
	public List<ClienteNativoDTO> findAllNativoComDTOReestruturado() {
		return clienteService.findAllNativoComDTOReestruturado();
	}
	
	
	
	
	@PostMapping
	public ClienteEntidade save(@RequestBody ClienteCreateDTO clienteCreate) {
		return clienteService.save(clienteCreate);
	}

}
