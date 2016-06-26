package market.main;

import java.util.ArrayList;
import java.util.Scanner;

import market.client.Address.Builder;
import market.client.Client;
import market.client.ClientDaoImp;
import market.data.FileManager;
import market.data.PdfGenerator;
import market.delivery.Entrega;
import market.delivery.Veiculo;
import market.item.Item;
import market.item.ItemDaoImp;
import market.order.Order;
import market.order.OrderItem;

public class MarketProvider {

	public static void main(String[] args) {

		/**
		 * Exemplo Pegando lista de clientes.
		 */
		// ClientDaoImp clientDao = ClientDaoImp.getInstance();

		// Adress endereco = new Adress.Builder()
		// .bairro("Novo Mundo")
		// .cep("81110-000")
		// .cidade("Curitiba")
		// .nr("085")
		// .rua("av. Republica Argentina")
		// .build();
		//
		// clientDao.addClient(new Client("Kuzma", "000.000.000-0001",
		// "1234-5478", endereco));

		// ArrayList<Client> clients = clientDao.getAllClients();

		/**
		 * Exemplo Pegando lista de items.
		 */
		// ItemDaoImp itemDao = ItemDaoImp.getInstance();

		// itemDao.addItem(new Item("Abacate", "kg", BigDecimal.valueOf(0d)));

		// ArrayList<Item> items = itemDao.getAllItems();

		/**
		 * Exemplo Pegando lista de veiculos.
		 */

		// VeiculoDaoImp veiculoDao = VeiculoDaoImp.getInstance();

		// Veiculo veiculo = new Veiculo("ZXC-9874", "Merceds", "preto", 4000);

		// veiculo.setEntrega(new Date());

		// veiculoDao.addVeiculo(veiculo);

		// ArrayList<Veiculo> veiculos = veiculoDao.getAllVeiculos();
		//
		// Order compra = new Order();
		// int i =1;
		// for(Item item:items){
		// item.setPreco(BigDecimal.valueOf(i*10));
		// compra.addOrderItem(new OrderItem(item, i));
		// i++;
		// compra.setClient(clients.get(0));
		// }
		//
		// Entrega entrega = new Entrega();
		//
		//
		//
		// PdfGenerator.create(compra);
		//
		// Veiculo v = entrega.alocarEntrega(compra);
		//
		// if(v != null){
		// System.out.println("Entrega sera feita pelo veiculo:
		// "+v.getMarca()+", Placa "+v.getPlaca());
		// }else{
		// System.out.println("Sem veiculos para entrega.");
		// }

		// FileManager.readOrder();
//		ClientDaoImp clientDao = ClientDaoImp.getInstance();
//		ItemDaoImp itemDao = ItemDaoImp.getInstance();
//		VeiculoDaoImp veiculoDao = VeiculoDaoImp.getInstance();

		menu();
	}

	public static void menu() {

		Scanner s = new Scanner(System.in);
		int op = 0;
		do {
			System.out.println("1 - Nova Order.");
			System.out.println("2 - Carregar Order.");
			System.out.println("3 - Estatisticas.");
			System.out.println("4 - Sair.");

			op = s.nextInt();

			switch (op) {
			case 1:
				novaCompra(new Order());
				break;
			case 2:
				novaCompra(FileManager.readOrder());
				break;
			default:
				break;
			}
		} while (op != 4);

	}

	public static void novaCompra(Order o) {
		if (o == null) {
			o = new Order();
		}
		Order order = o;
		Scanner s = new Scanner(System.in);
		int op = 0;
		do {
			System.out.println("1 - Adicionar Item.");
			System.out.println("2 - Selecionar Cliente.");
			System.out.println("3 - Ver Lista de compras.");
			System.out.println("4 - Finalizar Lista.");
			System.out.println("5 - Sair.(a compra atual será perdida)");

			op = s.nextInt();

			switch (op) {
			case 1:
				order.addOrderItem(adicionarItem());
				break;
			case 2:
				order.setClient(selecionarClient());
				break;
			case 3:
				printOrder(order);
				break;
			case 4:
				finishOrder(order);
				op = 5;
				break;
			}

		} while (op != 5);

	}

	private static void finishOrder(Order order) {
		if (order.getClient() == null) {
			order.setClient(selecionarClient());
		}
		Scanner s = new Scanner(System.in);
		System.out.println("Deseja salvar a lista com qual nome?");
		String fileName = s.nextLine();

		FileManager.writeOrder(order, fileName);

		Entrega entrega = new Entrega();

		PdfGenerator.create(order, fileName);

		Veiculo v = entrega.alocarEntrega(order);
		System.out.println();
		if (v != null) {
			System.out.println("Entrega sera feita pelo veiculo: " + v.getMarca() + ", Placa " + v.getPlaca());
		} else {
			System.out.println("Sem veiculos para entrega.");
		}
		System.out.println();
	}

	private static Client selecionarClient() {
		ArrayList<Client> list = ClientDaoImp.getInstance().getAllClients();
		Scanner s = new Scanner(System.in);
		int op = 0;
		int i;

		System.out.println();
		System.out.println();

		for (i = 0; i < list.size(); i++) {
			System.out.println(i + " - " + list.get(i).getNome());
		}

		System.out.println();
		System.out.println();

		do {
			System.out.println("Indice do Cliente ou -1 para criar um novo.");
			op = s.nextInt();
		} while (op < -1 && op > i);

		if (op == -1) {
			op = criarNovoClient();
			list = ClientDaoImp.getInstance().getAllClients();
		}

		return list.get(op);
	}

	private static int criarNovoClient() {
		Scanner s = new Scanner(System.in);

		System.out.println("Nome: ");
		String nome = s.nextLine();
		System.out.println("CNPJ: ");
		String cnpj = s.nextLine();
		System.out.println("Telefone: ");
		String telefone = s.nextLine();

		Builder b = new market.client.Address.Builder();

		System.out.println("Bairro: ");
		b.bairro(s.nextLine());
		System.out.println("CEP: ");
		b.cep(s.nextLine());
		System.out.println("Cidade: ");
		b.cidade(s.nextLine());
		System.out.println("Rua: ");
		b.rua(s.nextLine());
		System.out.println("NR: ");
		b.nr(s.nextLine());

		return ClientDaoImp.getInstance().addClient(new Client(nome, cnpj, telefone, b.build()));
	}

	private static void printOrder(Order order) {
		ArrayList<OrderItem> list = order.getItems();

		quebraLinha();

		if (order.getClient() != null) {
			System.out.println("Cliente: " + order.getClient().getNome());
			System.out.println("CNPJ: " + order.getClient().getCNPJ());
		}
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1 + " - " + list.get(i).getQtd() + "x " + list.get(i).getProduct().getNome()
					+ ", Preço: R$ " + list.get(i).getProduct().getPreco() + "/" + list.get(i).getProduct().getTipo());
		}
		System.out.println();
		System.out.println("Total: R$ " + order.getTotal());

		quebraLinha();

	}

	private static void quebraLinha() {
		System.out.println();
		System.out.println(
				"=======================================================================================================");
		System.out.println();
	}

	public static OrderItem adicionarItem() {
		ArrayList<Item> list = ItemDaoImp.getInstance().getAllItems();
		Scanner s = new Scanner(System.in);
		int op = 0;
		int i;
		for (i = 0; i < list.size(); i++) {
			System.out.println(i + " - " + list.get(i).getNome() + "/" + list.get(i).getTipo());
		}
		do {
			System.out.println("Entre com o codigo do item desejado ou -1 para adicionar um novo item a lista.");
			op = s.nextInt();
		} while (op < -1 && op > i);

		if (op == -1) {
			op = criarNovoItem();
			list = ItemDaoImp.getInstance().getAllItems();
		}

		int qtd = 0;
		do {
			System.out.println("Quantidade:");
			qtd = s.nextInt();
		} while (qtd < 0);

		double preco = 0;
		do {
			System.out.println("preco/unidade:");
			preco = s.nextDouble();
		} while (preco < 0);
		OrderItem item = new OrderItem(list.get(op), qtd);
		item.getProduct().setPreco(preco);
		return item;

	}

	private static int criarNovoItem() {
		Scanner s = new Scanner(System.in);

		System.out.println("Nome: ");
		String nome = s.nextLine();
		System.out.println("Tipo: ");
		String tipo = s.nextLine();

		return ItemDaoImp.getInstance().addItem(new Item(nome, tipo, 0));
	}

}
