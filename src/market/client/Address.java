package market.client;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Address implements Serializable{
	
	private String rua;
	private String nr;
	private String cep;
	private String bairro;
	private String cidade;
	
	public static class Builder{
		private String rua = new String("");
		private String nr = new String("");
		private String cep = new String("");
		private String bairro = new String("");
		private String cidade = new String("");
		
		public Builder rua(String rua) {
			this.rua = rua;
			return this;
		}
		public Builder nr(String nr) {
			this.nr = nr;
			return this;
		}
		public Builder cep(String cep) {
			this.cep = cep;
			return this;
		}
		public Builder bairro(String bairro) {
			this.bairro = bairro;
			return this;
		}
		public Builder cidade(String cidade) {
			this.cidade = cidade;
			return this;
		}
		public Address build() {
			return new Address(this);
		}
	}
	
	private Address(Builder builder) {
		this.rua = builder.rua;
		this.nr = builder.nr;
		this.cep = builder.cep;
		this.bairro = builder.bairro;
		this.cidade = builder.cidade;
	}
	
	public String getRua() {
		return rua;
	}
	public String getNr() {
		return nr;
	}
	public String getCep() {
		return cep;
	}
	public String getBairro() {
		return bairro;
	}
	public String getCidade() {
		return cidade;
	}
}
