package com.FreightFox.Service;

import com.FreightFox.Entity.Details;
import com.FreightFox.Exception.DetailsException;

public interface DetailsService {

	
	public Details addNewDetails(Details details) throws DetailsException;
}
