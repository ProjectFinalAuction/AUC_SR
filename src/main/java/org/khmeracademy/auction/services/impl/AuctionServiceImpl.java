package org.khmeracademy.auction.services.impl;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Auction;
import org.khmeracademy.auction.entities.AuctionInputUpdate;
import org.khmeracademy.auction.repositories.AuctionRepository;
import org.khmeracademy.auction.services.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionServiceImpl implements AuctionService{
	
	@Autowired
	private AuctionRepository auctionRepository;
	
	@Override
	public ArrayList<Auction> findAllAuctions() {
		return auctionRepository.findAllAuctions();
	}

	@Override
	public ArrayList<Auction> findAuctionByProductName(String product_name) {
		return auctionRepository.findAuctionByProductName(product_name);
	}

	@Override
	public ArrayList<Auction> findAuctionByDate(String trans_date) {
		return auctionRepository.findAuctionByDate(trans_date);
	}

	@Override
	public boolean addAuction(AuctionInputUpdate a) {
		return auctionRepository.addAuction(a);
	}

	@Override
	public boolean updateAuction(AuctionInputUpdate a) {
		return auctionRepository.updateAuction(a);
	}

	@Override
	public boolean deleteAuction(int auction_id) {
		return auctionRepository.deleteAuction(auction_id);
	}

}
