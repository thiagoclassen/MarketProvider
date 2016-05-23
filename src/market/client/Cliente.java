package market.client;

public class Cliente {
	
	private Adress endereco;
	private String nome;
	private String telefone;
	
	public Cliente(Adress endereco, String nome, String telefone) {
		this.endereco = endereco;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public Adress getEndereco() {
		return endereco;
	}
	public void setEndereco(Adress endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
