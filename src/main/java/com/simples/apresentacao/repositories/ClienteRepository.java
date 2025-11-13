package com.simples.apresentacao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simples.apresentacao.entities.ClienteEntidade;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntidade, Long>, JpaSpecificationExecutor<ClienteEntidade> {

	@Query(value = """
			SELECT c, p FROM ClienteEntidade c JOIN c.pedidos p
			""")
	List<?> findAllExplicito();


	@Query(value = """
			SELECT * FROM clientes c JOIN
			pedidos p ON p.cliente_id = c.cliente_id
			""", nativeQuery = true)
	List<?> findAllNativo();
	
}
