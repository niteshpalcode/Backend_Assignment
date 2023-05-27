package com.FreightFox.Service;

import com.FreightFox.Entity.Items;
import com.FreightFox.Exception.DetailsException;
import com.FreightFox.Exception.ItemsException;

public interface ItemsService {

	public Items addItems(Items items, Integer DetailsId)throws ItemsException,DetailsException;
}
