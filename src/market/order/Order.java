package market.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import market.client.Client;

@SuppressWarnings("serial")
public class Order implements Serializable{
	
	private ArrayList<OrderItem> items;
	private Client client;
	private Date date;
	
	public Order() {
		this.items = new ArrayList<OrderItem>();
		this.client = null;
		this.setDate(new Date());
	}

	public double getTotal(){
		double soma = 0;
		for(OrderItem item:items){
			soma += item.getProduct().getPreco()*item.getQtd();
		}
		return soma;
	}
	
//	public int getCarga(){
//		int carga = 0;
//		for(OrderItem item:items){
//			carga +=item.getQtd()*item.getProduct().getPeso();
//		}
//		return carga;
//	}
	
	public void addOrderItem(OrderItem Item){
		items.add(Item);
	}

	public ArrayList<OrderItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<OrderItem> items) {
		this.items = items;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
