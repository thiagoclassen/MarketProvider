package market.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import market.item.Item;
import market.item.ItemDaoImp;

public class MarketProvider {

	public static void main(String[] args) {

		
		/**
		 * Exemplo
		 * Pegando lista de clientes. 
		 */
//		ClientDaoImp clientDao = ClientDaoImp.getInstance();

//		Adress endereco = new Adress.Builder()
//				.bairro("Novo Mundo")
//				.cep("81110-000")
//				.cidade("Curitiba")
//				.nr("085")
//				.rua("av. Republica Argentina")
//				.build();
//		
//		clientDao.addClient(new Client("Kuzma", "000.000.000-0001", "1234-5478", endereco));
		
//		ArrayList<Client> clients = clientDao.getAllClients();

		/**
		 * Exemplo
		 * Pegando lista de items. 
		 */
		ItemDaoImp itemDao = ItemDaoImp.getInstance();

//		itemDao.addItem(new Item("Abacate", "kg", BigDecimal.valueOf(0d)));
		
		ArrayList<Item> items = itemDao.getAllItems();
		
		try {
			FileOutputStream os = new FileOutputStream(new File("data/teste.pdf"));
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, os);
			document.open();
			
			for(Item item:items){
				document.add(new Paragraph(item.getNome()+", Preço: R$"+item.getPreco().toString()+"/"+item.getTipo()));				
			}			
			
			document.close();
			
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
