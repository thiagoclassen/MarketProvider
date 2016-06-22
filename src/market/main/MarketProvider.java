package market.main;

import java.math.BigDecimal;
import java.util.ArrayList;

import market.client.Adress;
import market.client.Client;
import market.item.Item;
import market.order.OrderItem;

public class MarketProvider {
	
	public static void main(String[] args){
		
		Client teste = new Client(new Adress("Rua teste", 321, 84645431, "Bairro Teste", "Curitiba"), "Cliente A", "321654");
		
		OrderItem orderItem = new OrderItem(new Item("prdNome", "prdTipo", BigDecimal.valueOf(1.20f)), 1);
		
		ArrayList<OrderItem> prods = new ArrayList<OrderItem>();
		prods.add(orderItem);
		
//		NewOrder order = new NewOrder(prods, Calendar.getInstance(), teste, new Veiculo());
		
	}

}
