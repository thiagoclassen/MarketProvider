package market.client;

public class Adress {
	
	private String rua;
	private int nr;
	private int cep;
	private String bairro;
	private String cidade;
	
	public Adress(String rua, int nr, int cep, String bairro, String cidade) {
		this.rua = rua;
		this.nr = nr;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNr() {
		return nr;
	}
	public void setNr(int nr) {
		this.nr = nr;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
