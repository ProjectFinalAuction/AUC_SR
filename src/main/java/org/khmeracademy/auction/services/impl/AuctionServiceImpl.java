package org.khmeracademy.auction.services.impl;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Auction;
import org.khmeracademy.auction.entities.AuctionInputUpdate;
import org.khmeracademy.auction.entities.BiddingAuction;
import org.khmeracademy.auction.filtering.AuctionFilter;
import org.khmeracademy.auction.repositories.AuctionRepository;
import org.khmeracademy.auction.services.AuctionService;
import org.khmeracademy.auction.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionServiceImpl implements AuctionService{
	
	@Autowired
	private AuctionRepository auctionRepository;
	
	@Override
	public ArrayList<Auction> findAllAuctions(AuctionFilter filter, Pagination pagination) {
		System.out.println(pagination);
		pagination.setTotalCount(auctionRepository.count(filter));
		return auctionRepository.findAllAuctions(filter, pagination);
	}
	
	@Override
	public Auction getAuctionByID(int id) {
		return auctionRepository.getAuctionByID(id);
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

	@Override
	public ArrayList<Auction> findAuctionProductByCategory(int category_id) {
		// TODO Auto-generated method stub
		return auctionRepository.findAuctionProductByCategory(category_id);
	}

	@Override
	public BiddingAuction findBiddingAuctionByAuctionId(int auction_id) {
		
		return auctionRepository.findBiddingAuctionByAuctionId(auction_id);
	}


}
