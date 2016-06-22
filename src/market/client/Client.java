package market.client;

public class Client {
	
	private Adress endereco;
	private String nome;
	private String telefone;
	
	
	//TODO - Create Builder for Address
	public Client(Adress endereco, String nome, String telefone) {
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
