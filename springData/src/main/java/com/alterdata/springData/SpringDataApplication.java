package com.alterdata.springData;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alterdata.springData.model.Cargo;
import com.alterdata.springData.repository.RepositoryCargo;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final RepositoryCargo repository;
	
	public SpringDataApplication(RepositoryCargo repository) {
		this.repository = repository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cargo cargo = new Cargo();
		cargo.setDescricao("DESENVOLVEDOR DE SOFTWARE");
		
		repository.save(cargo);
	}

}
