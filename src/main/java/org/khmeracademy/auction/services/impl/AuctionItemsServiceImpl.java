package org.khmeracademy.auction.services.impl;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.AuctionItems;
import org.khmeracademy.auction.repositories.AuctionItemsRepository;
import org.khmeracademy.auction.services.AuctionItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionItemsServiceImpl implements AuctionItemsService{
	
	@Autowired
	private AuctionItemsRepository aucItemsRepository;
	
	@Override
	public ArrayList<AuctionItems> getAllAuctionItems() {
		// TODO Auto-generated method stub
		return aucItemsRepository.getAllAuctionItems();
	}

	@Override
	public boolean addAuctionItem(AuctionItems auctionItem) {
		// TODO Auto-generated method stub
		return aucItemsRepository.addAuctionItem(auctionItem);
	}

	@Override
	public boolean deleteActionItem(AuctionItems auctionItem) {
		// TODO Auto-generated method stub
		return aucItemsRepository.deleteActionItem(auctionItem);
	}

	@Override
	public boolean updateActionItem(AuctionItems aucitonItem) {
		// TODO Auto-generated method stub
		return aucItemsRepository.updateActionItem(aucitonItem);
	}

}
