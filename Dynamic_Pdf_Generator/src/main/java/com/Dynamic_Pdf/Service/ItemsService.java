package com.Dynamic_Pdf.Service;

import com.Dynamic_Pdf.Entity.Items;
import com.Dynamic_Pdf.Exception.DetailsException;
import com.Dynamic_Pdf.Exception.ItemsException;

public interface ItemsService {

	public Items addItems(Items items, Integer DetailsId)throws ItemsException,DetailsException;
}
