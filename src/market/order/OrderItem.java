package market.order;

import java.io.Serializable;

import market.item.Item;

@SuppressWarnings("serial")
public class OrderItem implements Serializable{
	
	private Item product;
	private int qtd;
	
	public OrderItem(Item product, int qtd) {
		this.product = product;
		this.qtd = qtd;
	}
	
	public Item getProduct() {
		return product;
	}
	public void setProduct(Item product) {
		this.product = product;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

}
