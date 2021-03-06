package market.client;

import java.util.ArrayList;

public interface ClientDao {
	public ArrayList<Client> getAllClients();
	public int addClient(Client client);
	public void updateClient(Client client);
	public void deleteClient(Client client);
}
