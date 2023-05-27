package com.FreightFox.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FreightFox.Entity.Details;
import com.FreightFox.Exception.DetailsException;
import com.FreightFox.Repository.DetailsRepository;

@Service
public class DetailsServiceImpl  implements DetailsService{

	@Autowired
	private DetailsRepository detailsRepository;

	@Override
	public Details addNewDetails(Details details) throws DetailsException {
		return detailsRepository.save(details);
	}
	
	
}
