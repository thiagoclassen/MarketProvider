package market.item;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Item implements Serializable{
	
	private String nome;
	private String tipo;
	private double preco;
	
	public Item(String nome, String tipo, double preco) {
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

}
