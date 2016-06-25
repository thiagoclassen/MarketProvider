package market.delivery;

import java.util.Date;

public class Veiculo {

	private String placa;
	private String marca;
	private String cor;
	private Date entrega;
	private int capacidade;

	public Veiculo(String placa, String marca, String cor, int capacidade) {
		this.placa = placa;
		this.marca = marca;
		this.cor = cor;
		this.entrega = null;
		this.capacidade = capacidade;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Date getEntrega() {
		return entrega;
	}

	public void setEntrega(Date entrega) {
		this.entrega = entrega;
	}

}
