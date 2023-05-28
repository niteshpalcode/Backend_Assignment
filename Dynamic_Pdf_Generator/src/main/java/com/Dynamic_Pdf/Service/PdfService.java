package com.Dynamic_Pdf.Service;

import java.io.ByteArrayInputStream;

import com.Dynamic_Pdf.Exception.DetailsException;

public interface PdfService {

	public ByteArrayInputStream createPdfById(Integer detailsrId) throws DetailsException;
}
