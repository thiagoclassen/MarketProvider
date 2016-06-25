package market.client;

import java.util.ArrayList;

import market.data.FileManager;

public class ClientDaoImp implements ClientDao {

	private static ArrayList<Client> clients;

	private static ClientDaoImp instance = null;

	public static ClientDaoImp getInstance() {

		if (instance == null) {
			instance = new ClientDaoImp();
			clients = FileManager.loadClients();
		}
		return instance;
	}

	private ClientDaoImp() {
		clients = new ArrayList<Client>();
	}

	@Override
	public ArrayList<Client> getAllClients() {
		return clients;
	}

	@Override
	public void addClient(Client client) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateClient(Client client) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteClient(Client client) {
		// TODO Auto-generated method stub

	}

}
