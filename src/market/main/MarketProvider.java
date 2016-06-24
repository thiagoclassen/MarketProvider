package market.main;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MarketProvider {
	
	public static void main(String[] args){
		
		JSONParser parser = new JSONParser();
		// String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
		try {
			Object obj = parser.parse(new FileReader("data/items.JSON"));

			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray list = (JSONArray)jsonObject.get("items");
			
			 Iterator<JSONObject> iterator = list.iterator();
	            while (iterator.hasNext()) {
	                System.out.println(iterator.next().get("telefone"));
	            }
			System.out.println();
			
			
		} catch (org.json.simple.parser.ParseException | IOException pe) {

			System.out.println("position: " + pe);
			System.out.println(pe);
		}
		
//		Client teste = new Client(new Adress("Rua teste", 321, 84645431, "Bairro Teste", "Curitiba"), "Cliente A", "321654");
//		
//		OrderItem orderItem = new OrderItem(new Item("prdNome", "prdTipo", BigDecimal.valueOf(1.20f)), 1);
//		
//		ArrayList<OrderItem> prods = new ArrayList<OrderItem>();
//		prods.add(orderItem);
		
//		NewOrder order = new NewOrder(prods, Calendar.getInstance(), teste, new Veiculo());
		
	}

}
