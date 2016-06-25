package market.data;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import market.client.Adress;
import market.client.Client;
import market.item.Item;

/**
 * @author Thiago
 *
 */
public class FileManager {

	@SuppressWarnings("unchecked")
	public static ArrayList<Item> loadItems() {

		JSONParser parser = new JSONParser();
		ArrayList<Item> items = new ArrayList<Item>();

		String nome = new String();
		String tipo = new String();
		BigDecimal preco;

		try {
			Object obj = parser.parse(new FileReader("data/items.JSON"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray list = (JSONArray) jsonObject.get("items");

			Iterator<JSONObject> iterator = list.iterator();
			
			while (iterator.hasNext()) {
				JSONObject item = iterator.next();
				nome = (String) item.get("nome");
				tipo = (String) item.get("tipo");
				preco = BigDecimal.valueOf((long)item.get("preco"));

				items.add(new Item(nome, tipo, preco));
			}

		} catch (org.json.simple.parser.ParseException | IOException pe) {
			System.out.println("FileManager | loadItems: " + pe);
		}

		return items;
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Client> loadClients() {
		
		JSONParser parser = new JSONParser();
		ArrayList<Client> clients = new ArrayList<Client>();

		String nome = new String();
		String cnpj = new String();
		String telefone = new String();
		Adress endereco = null;

		try {
			Object obj = parser.parse(new FileReader("data/clients.JSON"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray list = (JSONArray) jsonObject.get("clients");

			Iterator<JSONObject> iterator = list.iterator();
			
			while (iterator.hasNext()) {
				JSONObject client = iterator.next();
				nome = (String) client.get("nome");
				cnpj = (String) client.get("cnpj");
				telefone = (String) client.get("telefone");
				
				JSONObject address = (JSONObject) client.get("endereco");
				endereco = new Adress.Builder()
							.rua((String) address.get("rua"))
							.nr((String)address.get("nr"))
							.cep((String)address.get("cep"))
							.bairro((String) address.get("rua"))
							.cidade((String) address.get("cidade"))
							.build();
				
				clients.add(new Client(nome, cnpj, telefone, endereco));

			}

		} catch (org.json.simple.parser.ParseException | IOException pe) {
			System.out.println("FileManager | loadClients: " + pe);
		}
		
		return clients;
	}
}