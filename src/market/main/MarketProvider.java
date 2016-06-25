package market.main;

import java.util.ArrayList;

import market.client.Client;
import market.client.ClientDaoImp;
import market.item.Item;
import market.item.ItemDaoImp;

public class MarketProvider {

	public static void main(String[] args) {

		
		/**
		 * Exemplo
		 * Pegando lista de clientes. 
		 */
		ClientDaoImp clientDao = ClientDaoImp.getInstance();

//		Adress endereco = new Adress.Builder()
//				.bairro("Novo Mundo")
//				.cep("81110-000")
//				.cidade("Curitiba")
//				.nr("085")
//				.rua("av. Republica Argentina")
//				.build();
//		
//		clientDao.addClient(new Client("Kuzma", "000.000.000-0001", "1234-5478", endereco));
		
		ArrayList<Client> clients = clientDao.getAllClients();

		/**
		 * Exemplo
		 * Pegando lista de items. 
		 */
		ItemDaoImp itemDao =ItemDaoImp.getInstance();

//		itemDao.addItem(new Item("Abacate", "kg", BigDecimal.valueOf(0d)));
		
		ArrayList<Item> items = itemDao.getAllItems();
		
	}

}
