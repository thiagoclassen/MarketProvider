package market.order;

import java.util.ArrayList;
import java.util.Calendar;

import market.client.Cliente;
import market.product.Product;
import market.transport.Veiculo;

public class NewOrder {
	
	private ArrayList<Product> produtos;
	private float quantidade;
	private Calendar dataCompra;
	private Cliente cliente;
	private Veiculo veiculo;
	
	
	public ArrayList<Product> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Product> produtos) {
		this.produtos = produtos;
	}
	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	public Calendar getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Calendar dataCompra) {
		this.dataCompra = dataCompra;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	

}
