package com.simples.apresentacao;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simples.apresentacao.entities.EmployeeTeste;

@RestController
@RequestMapping("teste")
public class Controller {

	private EmployeeRepository employeeRepository;

	public Controller(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@GetMapping
	public List<EmployeeTeste> teste() {
		return employeeRepository.findAll();
	}

}
