package com.FreightFox.Service;

import java.io.ByteArrayInputStream;

import com.FreightFox.Exception.DetailsException;

public interface PdfService {

	public ByteArrayInputStream createPdfById(Integer detailsrId) throws DetailsException;
}
