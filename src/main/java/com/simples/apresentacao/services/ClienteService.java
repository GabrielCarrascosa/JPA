package com.simples.apresentacao.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.simples.apresentacao.dtos.ClienteComPedidosDTO;
import com.simples.apresentacao.dtos.ClienteConsultaNativaDTO;
import com.simples.apresentacao.dtos.ClienteConsultaNativaProjection;
import com.simples.apresentacao.dtos.ClienteCreateDTO;
import com.simples.apresentacao.dtos.ClienteDTO;
import com.simples.apresentacao.dtos.ClienteNativoDTO;
import com.simples.apresentacao.dtos.PedidoNativoDTO;
import com.simples.apresentacao.entities.ClienteEntidade;
import com.simples.apresentacao.mappers.ClienteMapper;
import com.simples.apresentacao.repositories.ClienteRepository;

import jakarta.transaction.Transactional;

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

	// Gerada automaticamenteo pelo JPA, sem getPedidos()
	public List<ClienteDTO> findAll() {
		List<ClienteEntidade> clientes = clienteRepository.findAll();
		return clientes.stream().map(clienteMapper::toClienteDTO).toList();
	}

	// Gerada automaticamenteo pelo JPA, com getPedidos()
	public List<ClienteComPedidosDTO> findAllComPedidos() {
		List<ClienteEntidade> clientes = clienteRepository.findAll();
		return clientes.stream().map(clienteMapper::toClienteComPedidosDTO).toList();
	}


	
	
	
	

	// Mesma coisa que a Gerada automaticamenteo pelo JPA, sem getPedidos(), mas criada na mão
	public List<ClienteDTO> findAllExplicito() {
		List<ClienteEntidade> clientes = clienteRepository.findAllExplicito();
		return clientes.stream().map(clienteMapper::toClienteDTO).toList();
	}

	// Mesma coisa que a Gerada automaticamenteo pelo JPA, com getPedidos(), mas criada na mão, ignora o LAZY da entidade
	public List<ClienteComPedidosDTO> findAllExplicitoComPedidos() {
		List<ClienteEntidade> clientes = clienteRepository.findAllExplicitoComPedidos();
		return clientes.stream().map(clienteMapper::toClienteComPedidosDTO).toList();
	}


	
	
	
	
	// Querry nativa retornando diretamente um DTO
	public List<ClienteConsultaNativaDTO> findAllNativoComDTO() {
		return clienteRepository.findAllNativoComDTO();
	}

	// Querry nativa retornando diretamente uma Projection
	public List<ClienteConsultaNativaProjection> findAllNativoComProjection() {
		return clienteRepository.findAllNativoComProjection();
	}


	
	
	
	
	// Ideia parecida com o findAll, mas é uma query nativa, logo getPedidos() não funcionaria
	public List<ClienteDTO> findAllClientesNativo() {
		List<ClienteEntidade> clientes = clienteRepository.findAllClientesNativo();
		return clientes.stream().map(clienteMapper::toClienteDTO).toList();
	}
	
	
	
	
	
	
	
	
	
	public List<ClienteNativoDTO> findAllNativo() {
		List<ClienteConsultaNativaProjection> clientes = clienteRepository.findAllNativo();
		List<Long> clienteIds = clientes.stream().map(cliente -> cliente.getClienteId()).toList();

		List<ClienteConsultaNativaProjection> pedidos = clienteRepository.findAllPedidosNativo(clienteIds);
		
		
		return clientes.stream().map(cliente -> {
			// pega todos os pedidos desse cliente
			List<PedidoNativoDTO> pedidosDoCliente = pedidos.stream()
					.filter(p -> p.getClienteId().equals(cliente.getClienteId()))
					.map(p -> new PedidoNativoDTO(p.getPedidoId(), p.getPedidoDescricao(), p.getPedidoData())).toList();

			// monta o record do cliente com a lista de pedidos
			return new ClienteNativoDTO(cliente.getClienteId(), cliente.getClienteNome(), cliente.getClienteEmail(),
					pedidosDoCliente);
		}).toList();
	}
	

	
	
	
	
	
	// Querry nativa retornando diretamente um DTO, mas reestruturando o DTO final
	public List<ClienteNativoDTO> findAllNativoComDTOReestruturado() {
		List<ClienteConsultaNativaDTO> clientesDTO = clienteRepository.findAllNativoComDTO();

		Map<Long, List<ClienteConsultaNativaDTO>> clientesAgrupados = clientesDTO.stream()
				.collect(Collectors.groupingBy(ClienteConsultaNativaDTO::clienteId));

		List<ClienteNativoDTO> clientesDTOFinal = clientesAgrupados.entrySet().stream().map(entry -> {
			Long clienteId = entry.getKey();
			List<ClienteConsultaNativaDTO> pedidosCliente = entry.getValue();

			List<PedidoNativoDTO> pedidos = pedidosCliente.stream()
					.map(p -> new PedidoNativoDTO(p.pedidoId(), p.pedidoDescricao(), p.pedidoData())).toList();

			ClienteConsultaNativaDTO first = pedidosCliente.get(0); // pega info do cliente do primeiro pedido

			return new ClienteNativoDTO(clienteId, first.clienteNome(), first.clienteEmail(), pedidos);
		}).toList();

		return clientesDTOFinal;
	}

	
	
	
	
	
	
	

	public Optional<ClienteEntidade> findById(Long id) {
		return clienteRepository.findById(id);
	}

	@Transactional
	public ClienteEntidade save(ClienteCreateDTO clienteCreate) {
		ClienteEntidade cliente = clienteMapper.toEntity(clienteCreate);
		return clienteRepository.save(cliente);
	}
}
