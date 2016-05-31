package market.main;

import java.util.ArrayList;
import java.util.Calendar;

import market.client.Adress;
import market.client.Cliente;
import market.data.Clients;
import market.order.NewOrder;
import market.order.OrderItem;
import market.product.Product;
import market.transport.Veiculo;

public class MarketProvider {
	
	public static void main(String[] args){
		
		Cliente teste = new Cliente(new Adress("Rua teste", 321, 84645431, "Bairro Teste", "Curitiba"), "Cliente A", "321654");
		
		OrderItem orderItem = new OrderItem(new Product("prdNome", "prdUnidade", "prdTipo", 1.20f), 1);
		
		ArrayList<OrderItem> prods = new ArrayList<OrderItem>();
		prods.add(orderItem);
		
		NewOrder order = new NewOrder(prods, Calendar.getInstance(), teste, new Veiculo());
		
	}

}
