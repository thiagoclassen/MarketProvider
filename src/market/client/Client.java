package market.client;

public class Client {
	
	private String nome;
	private String cnpj;
	private String telefone;
	private Address endereco;
	
	public Client(String nome, String cnpj, String telefone, Address endereco) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	public Address getEndereco() {
		return endereco;
	}
	public void setEndereco(Address endereco) {
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

	public String getCNPJ() {
		return cnpj;
	}

	public void setCNPJ(String cNPJ) {
		cnpj = cNPJ;
	}

}
