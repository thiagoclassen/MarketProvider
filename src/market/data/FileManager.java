package market.data;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.text.DateFormatter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import market.client.Address;
import market.client.Client;
import market.delivery.Veiculo;
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
				preco = BigDecimal.valueOf((long)(double)item.get("preco"));

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
		Address endereco = null;

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
				endereco = new Address.Builder()
							.rua((String) address.get("rua"))
							.nr((String)address.get("nr"))
							.cep((String)address.get("cep"))
							.bairro((String) address.get("bairro"))
							.cidade((String) address.get("cidade"))
							.build();
				
				clients.add(new Client(nome, cnpj, telefone, endereco));

			}

		} catch (org.json.simple.parser.ParseException | IOException pe) {
			System.out.println("FileManager | loadClients: " + pe);
		}
		
		return clients;
	}

	@SuppressWarnings("unchecked")
	public static void writeItems(ArrayList<Item> items) {

		JSONArray its = new JSONArray();
		for(Item item : items){
			JSONObject obj = new JSONObject();
			obj.put("preco", item.getPreco());
			obj.put("tipo", item.getTipo());
			obj.put("nome", item.getNome());
			its.add(obj);
		}
		
		JSONObject obj = new JSONObject();
		obj.put("items", its);
 
		try (FileWriter file = new FileWriter("data/items.JSON")) {
			file.write(obj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
		} catch (IOException e) {
			System.out.println("FileManager | writeItems: " + e);
		}
	}

	@SuppressWarnings("unchecked")
	public static void writeClients(ArrayList<Client> clients) {
		JSONArray cls = new JSONArray();
		for(Client client : clients){
			JSONObject obj = new JSONObject();
			obj.put("nome", client.getNome());
			obj.put("cnpj", client.getCNPJ());
			obj.put("telefone", client.getTelefone());

			//escrevendo objeto Adress
			JSONObject addres = new JSONObject();
			addres.put("bairro", client.getEndereco().getBairro());
			addres.put("cep", client.getEndereco().getCep());
			addres.put("cidade", client.getEndereco().getCidade());
			addres.put("nr", client.getEndereco().getNr());
			addres.put("rua", client.getEndereco().getRua());
			
			//setando adress no campo endereco
			obj.put("endereco", addres);
			cls.add(obj);
		}
		
		JSONObject obj = new JSONObject();
		obj.put("clients", cls);
 
		try (FileWriter file = new FileWriter("data/clients.JSON")) {
			file.write(obj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
		} catch (IOException e) {
			System.out.println("FileManager | writeItems: " + e);
		}		
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Veiculo> loadVeiculos() {
		JSONParser parser = new JSONParser();
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

		String placa = new String();
		String marca = new String();
		String cor = new String();
		String entrega = new String();
		int capacidade = 0;

		try {
			Object obj = parser.parse(new FileReader("data/veiculos.JSON"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray list = (JSONArray) jsonObject.get("veiculos");

			Iterator<JSONObject> iterator = list.iterator();
			
			while (iterator.hasNext()) {
				JSONObject item = iterator.next();
				placa = (String) item.get("placa");
				marca = (String) item.get("marca");
				cor = (String) item.get("cor");
				capacidade = (int)(long)item.get("capacidade");
				entrega = String.valueOf(item.get("entrega"));
				
				Veiculo veiculo = new Veiculo(placa, marca, cor, capacidade);
				
				if(!entrega.matches("null")){
					veiculo.setEntrega(new Date(Long.valueOf(entrega)));
				}else{
					veiculo.setEntrega(null);
				}

				veiculos.add(veiculo);
			}

		} catch (org.json.simple.parser.ParseException | IOException pe) {
			System.out.println("FileManager | loadVeiculos: " + pe);
		}

		return veiculos;
	}

	@SuppressWarnings("unchecked")
	public static void writeVeiculos(ArrayList<Veiculo> veiculos) {
		JSONArray its = new JSONArray();
		for(Veiculo veiculo : veiculos){
			JSONObject obj = new JSONObject();
			obj.put("placa", veiculo.getPlaca());
			obj.put("marca", veiculo.getMarca());
			obj.put("cor", veiculo.getCor());
			obj.put("entrega", veiculo.getEntrega() == null? "null": veiculo.getEntrega().getTime());
			obj.put("capacidade", veiculo.getCapacidade());
			its.add(obj);
		}
		
		
		
		JSONObject obj = new JSONObject();
		obj.put("veiculos", its);
 
		try (FileWriter file = new FileWriter("data/veiculos.JSON")) {
			file.write(obj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
		} catch (IOException e) {
			System.out.println("FileManager | writeItems: " + e);
		}
	}
		
}