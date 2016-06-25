package market.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import market.order.Order;
import market.order.OrderItem;

public class PdfGenerator {

	@SuppressWarnings("deprecation")
	public static void create(Order order) {

		String date = new String(
				order.getDate().getDate() + "-" + (order.getDate().getMonth() + 1) + "-" + order.getDate().getYear());

		String filename = new String("data/" + order.getClient().getNome() + "-" + date + ".pdf");

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
						+ item.getProduct().getPreco().toString() + "/" + item.getProduct().getTipo() + ", Total: R$"
						+ item.getProduct().getPreco().multiply(BigDecimal.valueOf(item.getQtd()))));
			}
			
			document.add(new Paragraph());
			
			document.add(new Paragraph("Total: R$"+order.getTotal().toString()));

			document.close();

		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
