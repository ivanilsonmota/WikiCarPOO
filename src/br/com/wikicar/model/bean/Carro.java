package br.com.wikicar.model.bean;

/**
 * @author Ivanilson P Mota
 */

public class Carro extends Veiculo {
    private int id;
    private String marca;
    private String modelo;
    private int anoLancamento;
    private int anoEncerramento;
    private String estadoConservacao;
    private Veiculo veiculo;
    
    public Carro() {
    }

    public Carro(String marca, String modelo, int anoLancamento, int anoEncerramento, String estadoConservacao, Veiculo veiculo) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoLancamento = anoLancamento;
        this.anoEncerramento = anoEncerramento;
        this.estadoConservacao = estadoConservacao;
        this.veiculo = veiculo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public int getAnoEncerramento() {
		return anoEncerramento;
	}

	public void setAnoEncerramento(int anoEncerramento) {
		this.anoEncerramento = anoEncerramento;
	}

	public String getEstadoConservacao() {
		return estadoConservacao;
	}

	public void setEstadoConservacao(String estadoConservacao) {
		this.estadoConservacao = estadoConservacao;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	
}