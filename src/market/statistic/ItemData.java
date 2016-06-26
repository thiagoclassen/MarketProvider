package market.statistic;

import market.item.Item;

@SuppressWarnings("serial")
public class ItemData extends Item{
	
	private int vendas;
	
	public ItemData(Item item, int vendas) {
		super(item.getNome(), item.getTipo(), item.getPreco()*vendas);
		this.vendas = vendas;
	}

	public int getVendas() {
		return vendas;
	}

	public void setVendas(int vendas) {
		this.vendas = vendas;
	}

	public void addVendas(int qtd) {
		this.vendas+=qtd;
	}
	
	public Double getPrecoMedio(){
		return (double)getPreco()/getVendas(); 
	}
	
}
