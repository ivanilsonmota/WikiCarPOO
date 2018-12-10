package br.com.wikicar.model.bean;

/**
 * @author Ivanilson P Mota
 */

public class Veiculo {
    private int id;
    private String nome;            
    private double capacidade;      
    
    public Veiculo() {
    }

    public Veiculo(String nome, String categoria, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(double capacidade) {
		this.capacidade = capacidade;
	}
    
}
