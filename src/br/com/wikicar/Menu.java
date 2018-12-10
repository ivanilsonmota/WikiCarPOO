package br.com.wikicar;

import java.util.Scanner;

import br.com.wikicar.model.bean.*;
import br.com.wikicar.model.dao.*;

/**
 * @author Ivanilson P Mota
 */

public class Menu {
	private Scanner sc = null;	
	public Menu() {
		layoutTelaInicial();
	}
	private void  layoutTelaInicial() {

			sc = new Scanner(System.in);
			System.out.println("|------------------------------------------------------------|");
			System.out.println("|                        WIKICAR                             |");
			System.out.println("|------------------------------------------------------------|\n"
							  +"| 1 | Cadastrar Veiculo                                      |\n"
							  +"|------------------------------------------------------------|\n"
							  +"| 2 | Cadastrar Carro                                        |\n"
							  +"|------------------------------------------------------------|\n"
							  +"| 3 | Listar Veiculos                                        |\n"
							  +"|------------------------------------------------------------|\n"
							  +"| 4 | Listar Carros                                          |\n"
							  +"|------------------------------------------------------------|\n"
							  +"| 0 | SAIR                                                   |\n"
							  +"|------------------------------------------------------------|\n");
									 
				System.out.print("\nDigite a opcao desejada: ");
				
				int op = sc.nextInt();
				
					switch(op) {
						case 0:
							System.exit(0);
							break;
						case 1: 
							layoutCadastrarVeiculo();
							break;
						case 2:
							layoutCadastrarCarro();
							break;
						case 3:
							layoutListarVeiculos();
							break;
						case 4:
							layoutListarCarros();
							break;
						default:
							System.out.println("Opcao invalida!");
							rodapeMenu();
							break;
					}
		
		
	}
	
	private void layoutCadastrarVeiculo() {
		String nome;
		double capacidade;
		
		
		sc = new Scanner(System.in);
		System.out.println("\n+------------------------------------------------------------+");
		System.out.println("|                     CADASTRO VEICULO                       |");
		System.out.println("+------------------------------------------------------------+\n");
		
		System.out.print("Nome: ");
		nome = sc.next();
		
		System.out.print("Capacidade: ");
		capacidade = sc.nextDouble();
	
		
		Veiculo v = new Veiculo();
		VeiculoDAO vdao = new VeiculoDAO();
		
		v.setNome(nome);
		v.setCapacidade(capacidade);
		vdao.save(v);
		
		rodapeMenu();
	}

	private void layoutCadastrarCarro() {
		String marca;
		String modelo;
		int anoLancamento;
		int anoEncerramento;
		String estadoConservacao;
		
		sc = new Scanner(System.in);
		System.out.println("\n|------------------------------------------------------------|");
		System.out.println("|                     CADASTRO CARRO                         |");
		System.out.println("|------------------------------------------------------------|\n");
		
		System.out.print("Marca: ");
		marca = sc.next();
		
		System.out.print("Modelo: ");
		modelo = sc.next();
	
		System.out.print("Ano lançamento: ");
		anoLancamento = sc.nextInt();
		
		System.out.print("Ano de encerramento: ");
		anoEncerramento = sc.nextInt();
		
		System.out.print("Estado de Conservacao: ");
		estadoConservacao = sc.next();
		
		Carro c = new Carro();
		CarroDAO cdao = new CarroDAO();
		
		c.setMarca(marca);
		c.setModelo(modelo);
		c.setAnoLancamento(anoLancamento);
		c.setAnoEncerramento(anoEncerramento);
		c.setEstadoConservacao(estadoConservacao);
		if(cdao.save(c))
			System.out.println("\nCarro cadastrado com sucesso!\n");
		
		rodapeMenu();
	}
	
	private void layoutListarVeiculos() {		
		VeiculoDAO vdao = new VeiculoDAO();	
		System.out.println("\n+------------------------------------------------------------+");
		System.out.println("|                     LISTA VEICULOS                         |");
		System.out.println("+--------+-----------------------------------+---------------+");
		System.out.println("|   ID   |            NOME VEICULO           |   CAPACIDADE  |");
		System.out.println("+--------+-----------------------------------+---------------+");
		
		for(Veiculo vei : vdao.findAll()) {
			System.out.println(String.format("%5s", "")
							  +String.format("%-20s", vei.getId()) 
					          +String.format("%-20s", vei.getNome())
					          +String.format("%10s", vei.getCapacidade()));
			System.out.println("+--------+-----------------------------------+---------------+");
		}
		
		rodapeMenu();
	}
	
	private void layoutListarCarros() {
		CarroDAO cdao = new CarroDAO();
		System.out.println("\n+----------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                         LISTA CARROS                                                                     |");
		System.out.println("+--------+-----------------------------------+---------------+----------+---------+-----------------+----------------------+---------------+");
		System.out.println("|   ID   |               MARCA               |     MODELO    | ANO LANC | ANO ENC |      ESTADO     |     TIPO VEICULO     |   CAPACIDADE  |");
		System.out.println("+--------+-----------------------------------+---------------+----------+---------+-----------------+----------------------+---------------+");
		for(Carro car : cdao.findAll()) {
			
			System.out.println(String.format("%5s", car.getId())
							  +String.format("%30s", car.getMarca())
							  +String.format("%20s", car.getModelo())
							  +String.format("%13s", car.getAnoLancamento())
							  +String.format("%11s", car.getAnoEncerramento())
							  +String.format("%13s", car.getEstadoConservacao())
							  +String.format("%20s", car.getVeiculo().getNome())
							  +String.format("%20s", car.getVeiculo().getCapacidade()));		
						
		}
		rodapeMenu();
	}
	
	private void rodapeMenu() {
		System.out.println("Digite 1 - Menu Inicial, 0 - Encerrar: ");
		int op = sc.nextInt();
		switch(op) {
			case 0: 
				System.exit(0);
				break;
			case 1:
				layoutTelaInicial();
				break;
			default: 
				System.out.println("Opcao digitada invalida!");
				break;
		}
	}
}
