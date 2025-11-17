package com.simples.apresentacao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simples.apresentacao.dtos.ClienteConsultaNativaDTO;
import com.simples.apresentacao.dtos.ClienteConsultaNativaProjection;
import com.simples.apresentacao.entities.ClienteEntidade;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntidade, Long>, JpaSpecificationExecutor<ClienteEntidade> {

	@Query(value = """
			SELECT * FROM clientes c
			""", nativeQuery = true)
	List<ClienteEntidade> findAllClientesNativo();
	
	
	
	
	
	

	@Query(value = """
			SELECT c FROM ClienteEntidade c
			""")
	List<ClienteEntidade> findAllExplicito();

	@Query(value = """
			SELECT c, p FROM ClienteEntidade c JOIN c.pedidos p
			""")
	List<ClienteEntidade> findAllExplicitoComPedidos();


	
	
	
	
	
	@Query(value = """
			SELECT
				c.cliente_id clienteId,
				c.nome clienteNome,
				c.email clienteEmail,
				p.pedido_id pedidoId,
				p.descricao pedidoDescricao,
				p.data pedidoData
			FROM clientes c JOIN
			pedidos p ON p.cliente_id = c.cliente_id
			""", nativeQuery = true)
	List<ClienteConsultaNativaDTO> findAllNativoComDTO();

	@Query(value = """
			SELECT
				c.cliente_id clienteId,
				c.nome clienteNome,
				c.email clienteEmail,
				p.pedido_id pedidoId,
				p.descricao pedidoDescricao,
				p.data pedidoData
			FROM clientes c JOIN
			pedidos p ON p.cliente_id = c.cliente_id
			""", nativeQuery = true)
	List<ClienteConsultaNativaProjection> findAllNativoComProjection();
	
	
	
	
	
	@Query(value = """
			SELECT
				p.pedido_id pedidoId,
				p.descricao pedidoDescricao,
				p.data pedidoData,
				p.cliente_id clienteId
			FROM pedidos p
			WHERE p.pedido_id IN :clienteIds
			""", nativeQuery = true)
	List<ClienteConsultaNativaProjection> findAllPedidosNativo(@Param("clienteIds") List<Long> clienteIds);

	@Query(value = """
			SELECT
				c.cliente_id clienteId,
				c.nome clienteNome,
				c.email clienteEmail
			FROM clientes c
			""", nativeQuery = true)
	List<ClienteConsultaNativaProjection> findAllNativo();

}
