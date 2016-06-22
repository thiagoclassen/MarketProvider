package market.item;

import java.math.BigDecimal;

public class Item {
	
	private String nome;
	private String tipo;
	private BigDecimal preco;
	
	public Item(String nome, String tipo, BigDecimal preco) {
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
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
