package market.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import market.client.Client;

public class Order {
	
	private ArrayList<OrderItem> items;
	private Client client;
	private Date date;
	
	public Order() {
		this.items = new ArrayList<OrderItem>();
		this.client = null;
		this.setDate(new Date());
	}

	public BigDecimal getTotal(){
		BigDecimal soma = BigDecimal.valueOf(0);
		for(OrderItem item:items){
			soma = soma.add(item.getProduct().getPreco().multiply(new BigDecimal(item.getQtd())));
		}
		return soma;
	}
	
	public void addOrderItem(OrderItem Item){
		items.add(Item);
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
