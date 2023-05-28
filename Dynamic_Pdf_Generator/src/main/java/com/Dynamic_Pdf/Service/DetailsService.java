package com.Dynamic_Pdf.Service;

import com.Dynamic_Pdf.Entity.Details;
import com.Dynamic_Pdf.Exception.DetailsException;

public interface DetailsService {

	
	public Details addNewDetails(Details details) throws DetailsException;
}
