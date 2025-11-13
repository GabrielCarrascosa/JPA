package com.simples.apresentacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.simples.apresentacao.entities.EmployeeTeste;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeTeste, Long>, JpaSpecificationExecutor<EmployeeTeste> {

}
