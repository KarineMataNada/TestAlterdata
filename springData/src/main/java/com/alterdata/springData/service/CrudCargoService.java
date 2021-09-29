package com.alterdata.springData.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.alterdata.springData.model.Cargo;
import com.alterdata.springData.repository.RepositoryCargo;

@Service
public class CrudCargoService {

	private Boolean system = true;
	
	private final RepositoryCargo repositoryCargo;
	
	public CrudCargoService(RepositoryCargo repositoryCargo) {
		this.repositoryCargo = repositoryCargo;
	}
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual acao voce quer executar?");
			System.out.println("0 - sair");
			System.out.println("1 - criar");
			System.out.println("2 - atualizar");
			System.out.println("3 - visualizar");
			System.out.println("4 - deletar");
			
			int action = scanner.nextInt();
			
			switch(action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
			    atualizar(scanner);
			    break;
			    
			case 3:
				visualizar();
			    break;
			        
			case 4:
				deletar(scanner);
			    break;    
			default:
				system = false;
				break;
				
			}
	}
		
 }

	private void salvar(Scanner scanner) {
		System.out.println("Descricao do Cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		repositoryCargo.save(cargo);
		System.out.println("Salvo");
		}
	
	private void atualizar(Scanner scanner) {
		System.out.println("id");
		Long id = scanner.nextLong();
		System.out.println("Descricao do Cargo atualizada");
		String descrisao = scanner.next();
		
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descrisao);
		repositoryCargo.save(cargo);
		System.out.println("Cargo atualizado");
	}
	
	private void visualizar() {
	 Iterable<Cargo> cargos = repositoryCargo.findAll();
	 cargos.forEach(cargo -> System.out.println(cargo));	
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("id");
		Long id = scanner.nextLong();
		repositoryCargo.deleteById(id);
		System.out.println("Cargo deletado");
	}
	
}
