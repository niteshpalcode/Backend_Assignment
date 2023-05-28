package com.Dynamic_Pdf.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dynamic_Pdf.Entity.Details;
import com.Dynamic_Pdf.Exception.DetailsException;
import com.Dynamic_Pdf.Repository.DetailsRepository;

@Service
public class DetailsServiceImpl  implements DetailsService{

	@Autowired
	private DetailsRepository detailsRepository;

	@Override
	public Details addNewDetails(Details details) throws DetailsException {
		return detailsRepository.save(details);
	}
	
	
}
