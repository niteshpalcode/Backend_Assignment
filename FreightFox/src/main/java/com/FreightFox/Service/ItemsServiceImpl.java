package com.FreightFox.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FreightFox.Entity.Details;
import com.FreightFox.Entity.Items;
import com.FreightFox.Exception.DetailsException;
import com.FreightFox.Exception.ItemsException;
import com.FreightFox.Repository.DetailsRepository;
import com.FreightFox.Repository.ItemsRepository;

@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsRepository itemsRepository;
	@Autowired
	private DetailsRepository detailsRepository;

	@Override
	public Items addItems(Items items, Integer DetailsId) throws ItemsException, DetailsException {
		Details isEsxt = detailsRepository.findById(DetailsId)
				.orElseThrow(() -> new DetailsException("Details is not matched with this id."));

		items.setDetails(isEsxt);
		return itemsRepository.save(items);
	}

}
