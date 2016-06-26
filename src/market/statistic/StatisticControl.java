package market.statistic;

import java.util.ArrayList;
import java.util.Collections;

import market.data.FileManager;
import market.order.Order;
import market.order.OrderItem;

public class StatisticControl {

	private static ArrayList<ItemData> itemsData;
	
	private static StatisticControl instance;

	public static StatisticControl getInstance(){
		
		if (instance == null) {
			instance = new StatisticControl();
			itemsData = FileManager.loadItemData();
		}
		return instance;
	}
	
	private StatisticControl() {
		itemsData = new ArrayList<ItemData>();
	}

	public void includeOrder(Order order) {

		for (OrderItem item : order.getItems()) {
			if (itemsData.size() == 0) {
				itemsData.add(new ItemData(item.getProduct(), item.getQtd()));
			} else {
					int idx = getIndex(item.getProduct().getNome());
					if(idx!=-1){
						itemsData.get(idx).addVendas(item.getQtd());
					}else{
						itemsData.add(new ItemData(item.getProduct(), item.getQtd()));
					}
				}
			}
			FileManager.writeItemData(itemsData);
		}
	
	public int getIndex(String nome){
		int i = -1;
		for (ItemData itemData : itemsData) {
			if (itemData.getNome().equals(nome)) {
				i = itemsData.indexOf(itemData);
				return i;
			}
		}
		return i;
	}

	public void printData() {
		Collections.sort(itemsData, new statisticComparator());
		int i = 0;
		System.out.println("");
		System.out.println("===================================================================");
		System.out.println("");
		System.out.println("Historico de vendas por Preco medio.");
		for (ItemData itemData : itemsData) {
			System.out.println((i + 1) + " - " + itemData.getNome() + ", Vendas: " + itemData.getVendas()
					+ ", PrecoMedio: R$ " + itemData.getPrecoMedio());
			i++;
		}
		System.out.println("");
		System.out.println("===================================================================");
		System.out.println("");
	}
}
