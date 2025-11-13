package com.simples.apresentacao.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.simples.apresentacao.entities.ClienteEntidade;
import com.simples.apresentacao.mappers.ClienteMapper;
import com.simples.apresentacao.repositories.ClienteRepository;

@Validated
@Service
public class ClienteService {
	private ClienteRepository clienteRepository;
	private ClienteMapper clienteMapper;

	public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
		super();
		this.clienteRepository = clienteRepository;
		this.clienteMapper = clienteMapper;
	}


	// 1 - (consulta derivada gerada automaticamente pelo Spring Data JPA)
	// findAll: Não traria, por causa do mapeamento Lazy

	// 4 - (consulta derivada gerada automaticamente pelo Spring Data JPA, porém com
	// um mapeamento Entidade -> DTO, utilizando ModelMapper)
	// findAll: Traria, pois quando é feito entidadeCliente.getProdutos(), a
	// consulta de produtos seria feita


	public List<ClienteEntidade> findAll() {
		return clienteRepository.findAll();
	}


	public List<?> findAllExplicito() {
		return clienteRepository.findAllExplicito();
	}


	public List<?> findAllNativo() {
		return clienteRepository.findAllNativo();
	}


}
