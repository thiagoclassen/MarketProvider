package market.order;

import java.util.ArrayList;
import java.util.Calendar;

import market.client.Cliente;
import market.product.Product;
import market.transport.Veiculo;

public class NewOrder {
	
	private ArrayList<OrderItem> produtos;
	private Calendar dataCompra;
	private Cliente cliente;
	private Veiculo veiculo;
	
	public NewOrder(ArrayList<OrderItem> produtos, Calendar dataCompra, Cliente cliente,
			Veiculo veiculo) {
		super();
		this.produtos = produtos;
		this.dataCompra = dataCompra;
		this.cliente = cliente;
		this.veiculo = veiculo;
	}
	
	public ArrayList<OrderItem> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<OrderItem> produtos) {
		this.produtos = produtos;
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
