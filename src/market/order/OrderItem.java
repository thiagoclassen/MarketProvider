package market.order;

import market.product.Product;

public class OrderItem {
	
	private Product product;
	private int qtd;
	
	public OrderItem(Product product, int qtd) {
		super();
		this.product = product;
		this.qtd = qtd;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	

}
