package market.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import market.order.Order;
import market.order.OrderItem;

public class PdfGenerator {

	public static void create(Order order, String fileName) {

		String path = new String("pdf/" + fileName + ".pdf");
		String filename = new String(path);

		try {
			FileOutputStream os = new FileOutputStream(new File(filename));
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, os);
			document.open();
			
			document.add(new Paragraph(order.getClient().getNome()+" - "+order.getClient().getCNPJ()));
			document.add(new Paragraph(order.getClient().getEndereco().getRua()+" "+order.getClient().getEndereco().getNr()+", "+order.getClient().getEndereco().getBairro()));
			document.add(new Paragraph(order.getClient().getEndereco().getCidade()+", CEP: "+order.getClient().getEndereco().getCep()));
			document.add(new Paragraph(order.getClient().getTelefone()));
			
			document.add(new Paragraph());
			
			for (OrderItem item : order.getItems()) {
				document.add(new Paragraph(item.getQtd() + " x " + item.getProduct().getNome() + ", Preço: R$"
						+ item.getProduct().getPreco() + "/" + item.getProduct().getTipo() + ", Total: R$"
						+ item.getProduct().getPreco()*item.getQtd()));
			}
			
			document.add(new Paragraph());
			
			document.add(new Paragraph("Total: R$"+order.getTotal()));

			document.close();

			System.out.println();
			System.out.println("Lista salva como pdf em: "+path);
			System.out.println();
			
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
