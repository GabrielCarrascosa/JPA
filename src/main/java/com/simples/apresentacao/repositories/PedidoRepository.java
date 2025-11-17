package com.simples.apresentacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.simples.apresentacao.entities.PedidoEntidade;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntidade, Long>, JpaSpecificationExecutor<PedidoEntidade> {
}
