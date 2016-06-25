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

		ArrayList<Client> clients = clientDao.getAllClients();

		/**
		 * Exemplo
		 * Pegando lista de items. 
		 */
		ItemDaoImp itemDao =ItemDaoImp.getInstance();

		ArrayList<Item> items = itemDao.getAllItems();
		
	}

}
