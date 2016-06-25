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
	public void updateClient(Client client) {
		// TODO - throw error if the client doesn't exists
		int pos = clients.indexOf(client);
		if (pos != -1) {
			clients.set(pos, client);
			writeClients();
		}

	}

	@Override
	public void deleteClient(Client client) {
		// TODO - throw error if the client doesn't exists
		int pos = clients.indexOf(client);
		if (pos != -1) {
			clients.remove(pos);
			writeClients();
		}
	}

	@Override
	public void addClient(Client client) {
		clients.add(client);
		writeClients();
	}

	private void writeClients() {
		FileManager.writeClients(clients);
	}

}
