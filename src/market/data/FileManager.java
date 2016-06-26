package market.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import market.client.Address;
import market.client.Client;
import market.delivery.Veiculo;
import market.item.Item;
import market.order.Order;
import market.statistic.ItemData;

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
		String preco = new String();

		try {
			Object obj = parser.parse(new FileReader("data/items.JSON"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray list = (JSONArray) jsonObject.get("items");

			Iterator<JSONObject> iterator = list.iterator();

			while (iterator.hasNext()) {
				JSONObject item = iterator.next();
				nome = (String) item.get("nome");
				tipo = (String) item.get("tipo");
				preco = (String) item.get("preco");

				items.add(new Item(nome, tipo, Double.parseDouble(preco)));
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
				endereco = new Address.Builder().rua((String) address.get("rua")).nr((String) address.get("nr"))
						.cep((String) address.get("cep")).bairro((String) address.get("bairro"))
						.cidade((String) address.get("cidade")).build();

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
		for (Item item : items) {
			JSONObject obj = new JSONObject();
			obj.put("preco", "0.0");
			obj.put("tipo", item.getTipo());
			obj.put("nome", item.getNome());
			its.add(obj);
		}

		JSONObject obj = new JSONObject();
		obj.put("items", its);

		try (FileWriter file = new FileWriter("data/items.JSON")) {
			file.write(obj.toJSONString());
			// System.out.println("Successfully Copied JSON Object to File...");
			// System.out.println("\nJSON Object: " + obj);
		} catch (IOException e) {
			System.out.println("FileManager | writeItems: " + e);
		}
	}

	@SuppressWarnings("unchecked")
	public static void writeClients(ArrayList<Client> clients) {
		JSONArray cls = new JSONArray();
		for (Client client : clients) {
			JSONObject obj = new JSONObject();
			obj.put("nome", client.getNome());
			obj.put("cnpj", client.getCNPJ());
			obj.put("telefone", client.getTelefone());

			// escrevendo objeto Adress
			JSONObject addres = new JSONObject();
			addres.put("bairro", client.getEndereco().getBairro());
			addres.put("cep", client.getEndereco().getCep());
			addres.put("cidade", client.getEndereco().getCidade());
			addres.put("nr", client.getEndereco().getNr());
			addres.put("rua", client.getEndereco().getRua());

			// setando adress no campo endereco
			obj.put("endereco", addres);
			cls.add(obj);
		}

		JSONObject obj = new JSONObject();
		obj.put("clients", cls);

		try (FileWriter file = new FileWriter("data/clients.JSON")) {
			file.write(obj.toJSONString());
			// System.out.println("Successfully Copied JSON Object to File...");
			// System.out.println("\nJSON Object: " + obj);
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
				capacidade = (int) (long) item.get("capacidade");
				entrega = String.valueOf(item.get("entrega"));

				Veiculo veiculo = new Veiculo(placa, marca, cor, capacidade);

				if (!entrega.matches("null")) {
					veiculo.setEntrega(new Date(Long.valueOf(entrega)));
				} else {
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
		for (Veiculo veiculo : veiculos) {
			JSONObject obj = new JSONObject();
			obj.put("placa", veiculo.getPlaca());
			obj.put("marca", veiculo.getMarca());
			obj.put("cor", veiculo.getCor());
			obj.put("entrega", veiculo.getEntrega() == null ? "null" : veiculo.getEntrega().getTime());
			obj.put("capacidade", veiculo.getCapacidade());
			its.add(obj);
		}

		JSONObject obj = new JSONObject();
		obj.put("veiculos", its);

		try (FileWriter file = new FileWriter("data/veiculos.JSON")) {
			file.write(obj.toJSONString());
			// System.out.println("Successfully Copied JSON Object to File...");
			// System.out.println("\nJSON Object: " + obj);
		} catch (IOException e) {
			System.out.println("FileManager | writeItems: " + e);
		}
	}

	@SuppressWarnings("resource")
	public static void writeOrder(Order order, String fileName) {
		try {
			FileOutputStream fout = new FileOutputStream("orders/" + fileName + ".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(order);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static Order readOrder() {
		Scanner s = new Scanner(System.in);
		System.out.println("Qual o nome do arquivo que deseja carregar?");
		String fileName = s.nextLine();
		try {
			ArrayList<Object> order = new ArrayList<Object>();
			FileInputStream fis = new FileInputStream("orders/" + fileName + ".ser");
			ObjectInputStream ois = new ObjectInputStream(fis);

			while (true) {
				order.add(ois.readObject());
				return (Order) order.get(0);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado.");
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("FileManager | readOrder: " + e.toString());
		}
		return null;
	}

	public static ArrayList<ItemData> loadItemData() {
		try {
			ArrayList<Object> order = new ArrayList<Object>();
			FileInputStream fis = new FileInputStream("stats/itemData.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);

			while (true) {
				order.add(ois.readObject());
				return (ArrayList<ItemData>) order.get(0);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado.");
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("FileManager | readOrder: " + e.toString());
		}
		return new ArrayList<ItemData>();
	}

	public static void writeItemData(ArrayList<ItemData> itemsData) {
		try {
			FileOutputStream fout = new FileOutputStream("stats/itemData.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(itemsData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}