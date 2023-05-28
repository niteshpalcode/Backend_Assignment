package com.Dynamic_Pdf.Controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Dynamic_Pdf.Entity.Details;
import com.Dynamic_Pdf.Entity.Items;
import com.Dynamic_Pdf.Exception.DetailsException;
import com.Dynamic_Pdf.Exception.ItemsException;
import com.Dynamic_Pdf.Service.DetailsService;
import com.Dynamic_Pdf.Service.ItemsService;
import com.Dynamic_Pdf.Service.PdfService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/generate")
public class PdfController {

	@Autowired
	private ItemsService itemsService;
	@Autowired
	private DetailsService detailsService;
	@Autowired
	private PdfService pdfService;

	@PostMapping("/addDetails")
	public ResponseEntity<Details> addNewDetails(@RequestBody Details details) throws DetailsException {
		return new ResponseEntity<Details>(detailsService.addNewDetails(details), HttpStatus.CREATED);
	}

	@PostMapping("/{detailsId}")
	public ResponseEntity<Items> addItems(@RequestBody Items items, @PathVariable("detailsId") Integer detailsId) throws ItemsException,DetailsException {

		return new ResponseEntity<Items>(itemsService.addItems(items, detailsId), HttpStatus.CREATED);
	}
	
	@GetMapping("/pdf/details/{invoiceId}")
	public ResponseEntity<InputStreamResource> getPdf(@PathVariable("invoiceId") Integer invoiceId)
			throws DetailsException{
		ByteArrayInputStream byteArrayInputStream = pdfService.createPdfById(invoiceId);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Desposition", "inline;file=data.pdf");
		return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(byteArrayInputStream));
	}
	

}
