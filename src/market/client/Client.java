package market.client;

public class Client {
	
	private String nome;
	private String cnpj;
	private String telefone;
	private Adress endereco;
	
	
	//TODO - Create Builder for Address
	public Client(String nome, String cnpj, String telefone, Adress endereco) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.endereco = endereco;
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

	public String getCNPJ() {
		return cnpj;
	}

	public void setCNPJ(String cNPJ) {
		cnpj = cNPJ;
	}

}
