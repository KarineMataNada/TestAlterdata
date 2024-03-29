package com.alterdata.springData;



import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.alterdata.springData.service.CrudCargoService;


@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;
	
	private Boolean system = true;
	
	public SpringDataApplication(CrudCargoService cargoService) {
		this. cargoService =  cargoService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	 
		Scanner scanner = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual acao voce quer executar?");
			System.out.println("0 - sair");
			System.out.println("1 - cargo");

			int action = scanner.nextInt();
			if(action == 1) {
				cargoService.inicial(scanner);
			} else {
				system = false;
			}
		}
	
	}

}
