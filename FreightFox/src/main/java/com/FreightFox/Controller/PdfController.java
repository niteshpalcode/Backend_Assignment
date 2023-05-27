package com.FreightFox.Controller;

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

import com.FreightFox.Entity.Details;
import com.FreightFox.Entity.Items;
import com.FreightFox.Exception.DetailsException;
import com.FreightFox.Exception.ItemsException;
import com.FreightFox.Service.DetailsService;
import com.FreightFox.Service.ItemsService;
import com.FreightFox.Service.PdfService;

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

	@PostMapping("/{sellerId}")
	public ResponseEntity<Items> addItems(@RequestBody Items items, @PathVariable("sellerId") Integer sellerId) throws ItemsException,DetailsException {

		return new ResponseEntity<Items>(itemsService.addItems(items, sellerId), HttpStatus.CREATED);
	}
	
	@GetMapping("/pdf/details/{detailsId}")
	public ResponseEntity<InputStreamResource> getPdf(@PathVariable("detailsId") Integer detailsId)
			throws DetailsException{
		ByteArrayInputStream byteArrayInputStream = pdfService.createPdfById(detailsId);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Desposition", "inline;file=data.pdf");
		return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(byteArrayInputStream));
	}
	

}
