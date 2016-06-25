package market.main;

import java.math.BigDecimal;
import java.util.ArrayList;

import market.client.Client;
import market.client.ClientDaoImp;
import market.data.PdfGenerator;
import market.delivery.Entrega;
import market.delivery.Veiculo;
import market.delivery.VeiculoDaoImp;
import market.item.Item;
import market.item.ItemDaoImp;
import market.order.Order;
import market.order.OrderItem;

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
		ItemDaoImp itemDao = ItemDaoImp.getInstance();

//		itemDao.addItem(new Item("Abacate", "kg", BigDecimal.valueOf(0d)));
		
		ArrayList<Item> items = itemDao.getAllItems();
		
		/**
		 * Exemplo
		 * Pegando lista de veiculos. 
		 */
		
		VeiculoDaoImp veiculoDao = VeiculoDaoImp.getInstance();
		
//		Veiculo veiculo = new Veiculo("ZXC-9874", "Merceds", "preto", 4000);
		
		
//		veiculo.setEntrega(new Date());
		
//		veiculoDao.addVeiculo(veiculo);
		
		ArrayList<Veiculo> veiculos = veiculoDao.getAllVeiculos();
		
		Order compra = new Order();
		int i =1;
		for(Item item:items){
			item.setPreco(BigDecimal.valueOf(i*10));
			compra.addOrderItem(new OrderItem(item, i));
			i++;
			compra.setClient(clients.get(0));
		}
		
		Entrega entrega = new Entrega();
		
		
		
		PdfGenerator.create(compra);
		
		Veiculo v = entrega.alocarEntrega(compra);
		
		if(v != null){
			System.out.println("Entrega sera feita pelo veiculo: "+v.getMarca()+", Placa "+v.getPlaca());
		}else{
			System.out.println("Sem veiculos para entrega.");
		}
		
		
		
	}

}
