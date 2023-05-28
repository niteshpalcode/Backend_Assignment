package com.Dynamic_Pdf.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dynamic_Pdf.Entity.Details;
import com.Dynamic_Pdf.Entity.Items;
import com.Dynamic_Pdf.Exception.DetailsException;
import com.Dynamic_Pdf.Exception.ItemsException;
import com.Dynamic_Pdf.Repository.DetailsRepository;
import com.Dynamic_Pdf.Repository.ItemsRepository;

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
