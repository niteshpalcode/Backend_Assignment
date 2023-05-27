package com.FreightFox.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FreightFox.Entity.Details;
import com.FreightFox.Entity.Items;
import com.FreightFox.Exception.DetailsException;
import com.FreightFox.Repository.DetailsRepository;
import com.FreightFox.Repository.ItemsRepository;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfServiceImpl implements PdfService {

	@Autowired
	private DetailsRepository detailsRepository;
	@Autowired
	private ItemsRepository itemsRepository;

	@Override
	public ByteArrayInputStream createPdfById(Integer detailsId) throws DetailsException {
		Details details = detailsRepository.findById(detailsId)
				.orElseThrow(() -> new DetailsException("No detials is found with this id"));

		
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		Document document = new Document();
		try {
			PdfWriter.getInstance(document, byteArrayOutputStream);
			document.open();
			
			PdfPTable table = new PdfPTable(2);
			table.setWidthPercentage(90);

			String sellerData = "Seller :\n" + details.getSeller() + "\n" + details.getSellerAddress() + "\n"
					+ "GSTIN : " + details.getSellerGstin();

			String buyer = "Buyer :" + "\n" + details.getBuyer() + "\n" + details.getBuyerAddress() + "\n" + "GSTIN: "
					+ details.getBuyerGstin();

			PdfPCell cell1 = new PdfPCell(new Phrase(sellerData));

			cell1.setPadding(20);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell1);

			PdfPCell cell2 = new PdfPCell(new Phrase(buyer));
			cell2.setPadding(20);
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell2);

			document.add(table);

			PdfPTable table2 = new PdfPTable(4);
			table2.setWidthPercentage(90);

			float[] columnWidths = { 2, 1, 1, 1 };
			table2.setWidths(columnWidths);
			PdfPCell cell1_1 = new PdfPCell(new Phrase("Item"));
			cell1_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1_1.setPaddingTop(5f); 
			cell1_1.setPaddingBottom(10f);
			table2.addCell(cell1_1);

			PdfPCell cell2_2 = new PdfPCell(new Phrase("Quantity"));
			cell2_2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2_2.setPaddingTop(5f); 
			cell2_2.setPaddingBottom(10f);
			table2.addCell(cell2_2);

			PdfPCell cell3 = new PdfPCell(new Phrase("Rate"));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setPaddingTop(5f); 
			cell3.setPaddingBottom(10f);
			table2.addCell(cell3);

			PdfPCell cell4 = new PdfPCell(new Phrase("Amount"));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell4.setPaddingTop(5f); 
			cell4.setPaddingBottom(10f);
			table2.addCell(cell4);

			document.add(table2);

			PdfPTable table1 = new PdfPTable(4);
			table1.setWidthPercentage(90);
			float[] columnWidthss = { 2, 1, 1, 1 };
			table1.setWidths(columnWidthss);

			List<Items> items = itemsRepository.findAll();
			if (!items.isEmpty()) {
				for(int i=0;i<items.size();i++) {
				Items item1 = items.get(i);

				PdfPCell nameCell = new PdfPCell(new Phrase(item1.getName()));
				nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				nameCell.setPaddingTop(5f);
				nameCell.setPaddingBottom(10f);
				table1.addCell(nameCell);

				PdfPCell amountCell = new PdfPCell(new Phrase(String.format("%.2f", item1.getAmount())));
				amountCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				amountCell.setPaddingTop(5f); 
				amountCell.setPaddingBottom(10f);
				table1.addCell(amountCell);

				PdfPCell quantityCell = new PdfPCell(new Phrase(item1.getQuantity()));
				quantityCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				quantityCell.setPaddingTop(5f);
				quantityCell.setPaddingBottom(10f);
				table1.addCell(quantityCell);

				PdfPCell rateCell = new PdfPCell(new Phrase(String.format("%.2f", item1.getRate())));
				rateCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				rateCell.setPaddingTop(5f); 
				rateCell.setPaddingBottom(10f);
				table1.addCell(rateCell);

				
				}
				document.add(table1);
			}

			PdfPTable table3 = new PdfPTable(1);
			table3.setWidthPercentage(90);
			PdfPCell quantityCell6 = new PdfPCell(new Phrase(" "));
			quantityCell6.setPaddingBottom(50f);
			table3.addCell(quantityCell6);

			document.add(table3);
			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
	}

}
