package com.simples.apresentacao.services;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.simples.apresentacao.dtos.PedidoCreateDTO;
import com.simples.apresentacao.entities.PedidoEntidade;
import com.simples.apresentacao.mappers.PedidoMapper;
import com.simples.apresentacao.repositories.PedidoRepository;

import jakarta.transaction.Transactional;

@Validated
@Service
public class PedidoService {
	private PedidoRepository pedidoRepository;
	private ClienteService clienteService;
	private PedidoMapper pedidoMapper;

	public PedidoService(PedidoRepository pedidoRepository, ClienteService clienteService, PedidoMapper pedidoMapper) {
		super();
		this.pedidoRepository = pedidoRepository;
		this.clienteService = clienteService;
		this.pedidoMapper = pedidoMapper;
	}

	// 1 - (consulta derivada gerada automaticamente pelo Spring Data JPA)
	// findAll: Não traria, por causa do mapeamento Lazy

	// 4 - (consulta derivada gerada automaticamente pelo Spring Data JPA, porém com
	// um mapeamento Entidade -> DTO, utilizando ModelMapper)
	// findAll: Traria, pois quando é feito entidadeCliente.getProdutos(), a
	// consulta de produtos seria feita

//
//	public List<ClienteEntidade> findAll() {
//		List<ClienteEntidade> clientes = clienteRepository.findAll();
//		return clientes;
//	}
//
//
//	public List<?> findAllExplicito() {
//		return clienteRepository.findAllExplicito();
//	}
//
//
//	public List<?> findAllNativo() {
//		return clienteRepository.findAllNativo();
//	}

	@Transactional
	public PedidoEntidade save(PedidoCreateDTO pedidoCreate) {
		PedidoEntidade pedido = pedidoMapper.toEntity(pedidoCreate, clienteService.findById(pedidoCreate.clienteId()).get());
		return pedidoRepository.save(pedido);
	}


}
