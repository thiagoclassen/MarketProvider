package market.product;

public class Product {
	
	private String nome;
	private String unidadeDeMedida;
	private String tipo;
	private float preco;
	
	public Product(String nome, String unidadeDeMedida, String tipo, float preco) {
		super();
		this.nome = nome;
		this.unidadeDeMedida = unidadeDeMedida;
		this.tipo = tipo;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}
	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}

}
