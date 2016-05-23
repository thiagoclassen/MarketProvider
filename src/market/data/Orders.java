package market.data;

import java.util.ArrayList;

import market.client.Cliente;
import market.order.NewOrder;
import market.order.OrderItem;

public class Orders {
	
	private ArrayList<OrderItem> orders;

	public ArrayList<OrderItem> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<OrderItem> orders) {
		this.orders = orders;
	}

}
